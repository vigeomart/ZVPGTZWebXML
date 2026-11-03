package zvpgtz;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DOMReadZVPGTZ {
    private File xmlFile = null;
    private Document doc = null;

    public Document getDocument(){
        return this.doc;
    }

    public void readFromXML(String fileLocation){
        xmlFile = new File(fileLocation);

        if (!xmlFile.exists()) {
            return;
        }
    }

    public void buildDocument(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
             builder = factory.newDocumentBuilder();
             doc = builder.parse(xmlFile);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public Element getRootElement()  {
        buildDocument();
        return doc.getDocumentElement();
    }

    public void printElement(Element element, int depth) {
      StringBuilder line = new StringBuilder("  ".repeat(depth)).append(element.getTagName());
      NamedNodeMap attrs = element.getAttributes();
      for (int i = 0; i < attrs.getLength(); i++) {
        line.append(" @").append(attrs.item(i).getNodeName())
            .append('=').append(attrs.item(i).getNodeValue());
      }
      List<Element> children = childElements(element);
      if (children.isEmpty()) {
        line.append(" = ").append(element.getTextContent().strip());
      }
      System.out.println(line);
      for (Element child : children) {
        printElement(child, depth + 1);
      }
    }

    public static List<Element> childElements(Element parent) {
      List<Element> result = new ArrayList<>();
      for (Node n = parent.getFirstChild(); n != null; n = n.getNextSibling()) {
        if (n.getNodeType() == Node.ELEMENT_NODE) {
          result.add((Element) n);
        }
      }
      return result;
    }
}
