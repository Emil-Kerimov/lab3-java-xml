package Task1;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class SAXParserTask {
    public static void parse(String fileName){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            DefaultHandler handler = new SAXHandler();
            InputStream xmlStream = new FileInputStream(fileName);
            parser.parse(xmlStream, handler);
            Set<String> tags = ((SAXHandler) handler).getTags();
            System.out.println("Список тегів:");
            for (String tag : tags) {
                System.out.println(tag);
            }
        } catch (ParserConfigurationException e){
            e.printStackTrace();
        } catch (SAXException e){
            e.printStackTrace();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        SAXParserTask.parse("Popular_Baby_Names_NY.xml");
    }
}
