import zvpgtz.*;

public class Main {
    void main() {
        DOMReadZVPGTZ dom = new DOMReadZVPGTZ();
        String filePath = "/home/martin/Egyetem/5.félév/ZVPGTZWebXML/ZVPGTZ_1021/DomParseZVPGTZ/src/zvpgtz/ZVPGTZ_XML.xml";
        dom.readFromXML(filePath);

        //dom.printElement(dom.getRootElement(), 0);

        DOMModifyZVPGTZ modifyZVPGTZ = new DOMModifyZVPGTZ(dom);

        //modifyZVPGTZ.modifyElements(filePath);

        DOMQueryZVPGTZ query = new DOMQueryZVPGTZ(dom);

        query.getSzakacs();
    }
}
