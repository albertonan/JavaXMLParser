package com.nan.javaxmlparser;

import com.nan.javaxmlparser.NodeObject;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class XMLParser {

    NodeObject node;

    public XMLParser(String data) {
        Document doc = convertStringToXMLDocument(data);
        Node nodeDoc = doc.getFirstChild();
        node = parseXML((nodeDoc));
    }

    // Recursive parse from XML Document
    private NodeObject parseXML(Node node) {
        NodeObject nodeObject = new NodeObject();
        nodeObject.setNodeName(node.getNodeType()!=3?node.getNodeName():"");
        nodeObject.setNodeValue(node.getNodeType()==3?node.getNodeValue():"");
        NodeList nodeList = node.getChildNodes();
        NamedNodeMap nnp = node.getAttributes();
        if (nnp != null) {
            for (int i = 0; i < nnp.getLength(); i++) {
                nodeObject.addAttribute(nnp.item(i).getNodeName(), nnp.item(i).getNodeValue());
            }
        }
        if (nodeList != null) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                nodeObject.addChildNode(parseXML(nodeList.item(i)));
            }
        }
        return nodeObject;
    }

    // Parse string to Document
    private static Document convertStringToXMLDocument(String xmlString) {
        // Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // API to obtain DOM Document instance
        DocumentBuilder builder;
        try {
            // Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            // Parse the content to Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public NodeObject getObject() {
        return node;
    }

}
