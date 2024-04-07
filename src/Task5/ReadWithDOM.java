package Task5;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadWithDOM {
    public static void main(String[] args) {
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            File xmlFile = new File("top_popular_names.xml");
            Document doc = builder.parse(xmlFile);
            Element root = doc.getDocumentElement();

            NodeList nameList = root.getElementsByTagName("child");

            for(int i = 0; i < nameList.getLength(); i++){
                Node nameNode = nameList.item(i);
                if(nameNode.getNodeType() == Node.ELEMENT_NODE){
                    Element nameElement = (Element) nameNode;
                    String name = nameElement.getElementsByTagName("name").item(0).getTextContent();
                    String gender = nameElement.getElementsByTagName("gender").item(0).getTextContent();
                    int count = Integer.parseInt(nameElement.getElementsByTagName("count").item(0).getTextContent());
                    int rank = Integer.parseInt(nameElement.getElementsByTagName("rank").item(0).getTextContent());

                    System.out.println("Name: " + name);
                    System.out.println("Gender: " + gender);
                    System.out.println("Count: " + count);
                    System.out.println("Rank in their group: " + rank);
                    System.out.println();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
