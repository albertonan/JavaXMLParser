import javax.sound.sampled.SourceDataLine;

import com.nan.javaxmlparser.NodeObject;
import com.nan.javaxmlparser.XMLParser;

public class Test{
    public static void main(String[] args){
        final String testXML = "<nan id=\"myNameIsAlbert\"><name>Albert</name><lastname>Nan</lastname></nan>";
        XMLParser xmlParsed = new XMLParser(testXML);
        printParsedXML(xmlParsed.getObject());
    }

    static private void printParsedXML(NodeObject node){
        if(!node.getNodeName().equals("")){
            System.out.print("<");
            System.out.print(node.getNodeName()+" ");
        }
        if(!node.getNodeValue().equals(""))System.out.print(node.getNodeValue());
        node.getAttributes().forEach((key, value)->{
            System.out.print(key+" = "+value);
        });
        if(!node.getNodeName().equals(""))System.out.print(">");
        node.getChildNodes().forEach(childNode->{
            printParsedXML(childNode);
        });
        if(!node.getNodeName().equals(""))System.out.println("</"+node.getNodeName()+">");
    }
}
