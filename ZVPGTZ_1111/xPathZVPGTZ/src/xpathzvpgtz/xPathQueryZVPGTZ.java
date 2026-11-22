package xpathzvpgtz;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

public class xPathQueryZVPGTZ  {
  public void printStuff(String fileName) 
    try {
      DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

      Document doc = documentBuilder.parse("/home/martin/Egyetem/5.félév/ZVPGTZWebXML/ZVPGTZ_1111/studentZVPGTZ.xml");
      doc.getDocumentElement().normalize();

      XPath xpath = XPathFactory.newInstance().newXPath();

      String neptunkod = "/hallgato/student";

      System.out.println("Futás eredménye");

      NodeList neptunKod = (NodeList) xpath.compile(neptunkod).evaluate(doc, XPathConstants.NODESET);

      BufferedWriter writer = new BufferedWriter(new FileWriter("studentZVPGTZ.xml"));

      writer.write("<?xml version=\"1.0\"> encoding=\"UTF-8\"?>\n");
      writer.write("<hallgatok>\n");

      for (int i = 0; i < neptunKod.getLength(); i++) {

        Node node = neptunKod.item(i);

        System.out.println("\nAktuális elem:");

        if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("hallgato")) {

          Element element = (Element) node;

          String id = element.getAttribute("id");

          String keresztnev = element.getElementsByTagName("keresztnev").item(0).getTextContent();
          String vezeteknev = element.getElementsByTagName("vezeteknev").item(0).getTextContent();
          String foglalkozas = element.getElementsByTagName("foglalkozas").item(0).getTextContent();

          System.out.println("Hallgató id: " + id);
          System.out.println("Keresztnev: " + keresztnev);
          System.out.println("Foglalkozás:" + foglalkozas);
        }

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
