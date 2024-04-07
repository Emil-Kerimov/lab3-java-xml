package Task2;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;

public class SAXValidate {
    public static void parse(String xmlFileName, String xsdFileName) {
        Schema schema = null;
        try {
            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory factory = SchemaFactory.newInstance(language);
            schema = factory.newSchema(new File(xsdFileName));
        } catch (Exception e) { e.printStackTrace(); }
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(false);
        factory.setSchema(schema);
        factory.setNamespaceAware(true);

        try {
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new SAXErrorCheckHandler();
            InputStream xmlInput = new FileInputStream(xmlFileName);
            saxParser.parse(xmlInput, handler);
        }
        catch (SAXException e) { e.printStackTrace(); }
        catch (ParserConfigurationException e) { e.printStackTrace(); }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }

    public static void main(String[] args) {
        SAXValidate.parse("Popular_Baby_Names_NY.xml","Popular_Baby_Names_NY.xsd");
    }
}
