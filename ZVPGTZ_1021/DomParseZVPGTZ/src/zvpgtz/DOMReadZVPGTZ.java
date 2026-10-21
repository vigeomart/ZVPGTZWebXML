package zvpgtz;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMReadZVPGTZ {
     void main() throws ParserConfigurationException, IOException, SAXException {
         File xmlFile = null;
         try {
            xmlFile = new File("ZVPGTZ_orarend.xml");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        System.out.println("Gyökér elem:" + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("ora");

        System.out.println(nList.getLength());

        for (int i = 0; i < nList.getLength() ; i++) {
            Node nNode = nList.item(i);

            System.out.println("Aktuális elem: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE){
                Element elem = (Element) nNode;

                String id = elem.getAttribute("name");

                String tipus = elem.getAttribute("tipus");


            }

        }

    }
}
