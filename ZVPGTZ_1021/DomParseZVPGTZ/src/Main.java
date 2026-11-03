import zvpgtz.*;

public class Main {
    void main() {
        DOMReadZVPGTZ dom = new DOMReadZVPGTZ();
        String filePath = "/home/vigeomart/Egyetem/5.félév/ZVPGTZWebXML/ZVPGTZ_1021/DomParseZVPGTZ/src/zvpgtz/ZVPGTZ_XML.xml";

        DOMModifyZVPGTZ modifyZVPGTZ = new DOMModifyZVPGTZ(dom);

        modifyZVPGTZ.modifyElements(filePath);
    }
}
