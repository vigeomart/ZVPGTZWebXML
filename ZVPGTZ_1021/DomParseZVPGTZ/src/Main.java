import zvpgtz.*;
void main() {
    DOMReadZVPGTZ dom = new DOMReadZVPGTZ();
    dom.readFromXML("/home/martin/Egyetem/5.félév/ZVPGTZWebXML/ZVPGTZ_1021/DomParseZVPGTZ/src/zvpgtz/ZVPGTZ_XML.xml");


    dom.printElement(dom.getRootElement(), 0);
}
