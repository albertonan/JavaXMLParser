package com.nan.javaxmlparser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodeObject {
    Map<String, String> attributes = new HashMap<>();
    List<NodeObject> childNodes = new ArrayList<>();
    String nodeName, nodeValue;

    public void addChildNode(NodeObject node){
        childNodes.add(node);
    }

    public void addAttribute(String key, String value){
        attributes.put(key, value);
    }

    public Map<String, String> getAttributes(){
        return attributes;
    }

    public List<NodeObject> getChildNodes(){
        return childNodes;
    }

    public void setNodeName(String nodeName){
        this.nodeName = nodeName;
    }

    public String getNodeName(){
        return nodeName;
    }

    public void setNodeValue(String nodeValue){
        this.nodeValue = nodeValue;
    }

    public String getNodeValue(){
        return nodeValue;
    }
}

