package Task3;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;
public class NationalGroupExt {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();

            factory.setValidating(false);

            SAXParser parser = factory.newSAXParser();

            NationalGroupHandler handler = new NationalGroupHandler();

            parser.parse("Popular_Baby_Names_NY.xml", handler);

            Set<String> nationalGroups = handler.getNationalGroups();
            System.out.println("Назви національних груп:");
            for (String group : nationalGroups) {
                System.out.println(group);
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
