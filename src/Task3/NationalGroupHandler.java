package Task3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

public class NationalGroupHandler extends DefaultHandler {
    private Set<String> nationalGroups = new HashSet<>();
    private boolean isInNationalGroup = false;



    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("ethcty")) {
            isInNationalGroup = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("ethcty")) {
            isInNationalGroup = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInNationalGroup) {
            String group = new String(ch, start, length).trim();
            if (!group.isEmpty()) {
                nationalGroups.add(group);
            }
        }
    }

    public Set<String> getNationalGroups() {
        return nationalGroups;
    }
}
