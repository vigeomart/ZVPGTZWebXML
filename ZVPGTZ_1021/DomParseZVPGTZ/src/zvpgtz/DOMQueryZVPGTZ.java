package zvpgtz;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import zvpgtz.DOMReadZVPGTZ;

public class DOMQueryZVPGTZ {
    private DOMReadZVPGTZ dom;
    private Document doc;

    public DOMQueryZVPGTZ(DOMReadZVPGTZ dom){
        this.dom = dom;
        dom.buildDocument();
        this.doc = dom.getDocument();
    }

    public void getSzakacs(){
        NodeList szakacsList = doc.getElementsByTagName("Szakacs");
        for (int i = 0; i < szakacsList.getLength(); i++) {
            Node node = szakacsList.item(i);


            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                NodeList vegzettsegList = elem.getElementsByTagName("Vegzettseg");
                System.out.println(vegzettsegList.getLength());

                for (int j = 0; j < vegzettsegList.getLength(); j++) {
                    String vegzettseg = vegzettsegList.item(j).getTextContent();
                    if (vegzettseg.toLowerCase().equals("szakközépiskola")) {
                        String nev = elem.getElementsByTagName("Nev").item(0).getTextContent();
                        String reszleg = elem.getElementsByTagName("Reszleg").item(0).getTextContent();
                        String szakacsVegzettseg = elem.getElementsByTagName("Vegzettseg").item(0).getTextContent();
                        String id = elem.getAttributes().getNamedItem("sz_e").getNodeValue();
                        System.out.println("Név: " + nev);
                        System.err.println("Részleg: " + reszleg);
                        System.out.println("Végzettség: " +szakacsVegzettseg);
                        System.out.println("A szakács->étterem: "+ id);
                        break;
                    }
                }
            }

        }
    }
    public void get5CsillagosEtterem(){
        NodeList etteremList = doc.getElementsByTagName("Etterem");

        for (int i = 0; i < etteremList.getLength(); i++) {
            Node node = etteremList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem =(Element) node;

            }
        }
    }
}
