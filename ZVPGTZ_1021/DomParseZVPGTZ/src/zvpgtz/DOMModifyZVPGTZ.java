package zvpgtz;

import java.io.File;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMModifyZVPGTZ {
    private DOMReadZVPGTZ dom;

    public DOMModifyZVPGTZ(DOMReadZVPGTZ dom){
        this.dom = dom;
    }

    public void modifyElements(String fileLocation) {
        dom.readFromXML(fileLocation);
        dom.buildDocument();
        Document doc = dom.getDocument();

        if (doc == null) {
            System.out.println("Hiba: A dokumentum nem betölthető!");
            return;
        }

        NodeList vendegList = doc.getElementsByTagName("Vendeg");
        for (int i = 0; i < vendegList.getLength(); i++) {
            Element vendeg = (Element) vendegList.item(i);
            if ("1".equals(vendeg.getAttribute("vkod"))) {
                NodeList nevList = vendeg.getElementsByTagName("Nev");
                if (nevList.getLength() > 0) {
                    nevList.item(0).setTextContent("Kis BÉla");
                }
                NodeList eletkorList = vendeg.getElementsByTagName("Eletkor");
                if (eletkorList.getLength() > 0) {
                    eletkorList.item(0).setTextContent("25");
                }
            }
        }

        NodeList gyakornokList = doc.getElementsByTagName("Gyakornok");
        for (int i = 0; i < gyakornokList.getLength(); i++) {
            Element gyakornok = (Element) gyakornokList.item(i);
            if (gyakornok.hasAttribute("gy_e")) {
                gyakornok.setAttribute("gy_e", "e3");
            }
        }

        NodeList rendelesList = doc.getElementsByTagName("Rendeles");
        for (int i = rendelesList.getLength() - 1; i >= 0; i--) {
            Node rendeles = rendelesList.item(i);
            Node parent = rendeles.getParentNode();
            if (parent != null) {
                parent.removeChild(rendeles);
            }
        }

        saveXML(fileLocation, doc);

        System.out.println("\n--- Módosított XML fa ---");
        dom.printElement(doc.getDocumentElement(), 0);
    }

    private void saveXML(String fileLocation, Document doc) {
        try {
            doc.normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileLocation));
            transformer.transform(source, result);

            System.out.println("Az XML fájl sikeresen módosítva és elmentve.");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
