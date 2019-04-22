import common.Utility;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.ximpleware.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static common.Utility.ReadXMLFile;
import static org.jsoup.nodes.Document.OutputSettings.Syntax.xml;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

//https://regex101.com/
public class Regex {
    String regex = "(?<=<author>).+?(?=</author)";
    String text = "<w:r>\n" +
            "<w:rPr>\n" +
            "<w:rFonts w:ascii=\"Helvetica\" w:h-ansi=\"Helvetica\" w:cs=\"Helvetica\"/>\n" +
            "<wx:font wx:val=\"Helvetica\"/>\n" +
            "<w:sz w:val=\"24\"/>\n" +
            "<w:sz-cs w:val=\"24\"/>\n" +
            "</w:rPr>\n" +
            "<w:t> <author>Gambardella, Matthew</author></w:t>\n" +
            "</w:r>\n" +
            "</w:p>\n" +
            "<w:p>\n" +
            "<w:pPr/>\n" +
            "<w:r>\n" +
            "<w:rPr>\n" +
            "<w:rFonts w:ascii=\"Helvetica\" w:h-ansi=\"Helvetica\" w:cs=\"Helvetica\"/>\n" +
            "<wx:font wx:val=\"Helvetica\"/>\n" +
            "<w:sz w:val=\"24\"/>\n" +
            "<w:sz-cs w:val=\"24\"/>\n" +
            "</w:rPr>\n" +
            "<w:t> <title>XML Developer's Guide</title></w:t>\n" +
            "</w:r>\n" +
            "</w:p>\n" +
            "<w:p>";

    File fileXmlBooks = new File(System.getProperty("user.home")+"/Desktop/qalife/src/test/resources/Files/books.xml");

    @Test
    public void regexFoundFromStringText() throws Exception{
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile(regex)
                .matcher(text);
        while (m.find()) {
            allMatches.add(m.group());
        }
        System.out.println("Found in text: "+allMatches+"\n");
    }

    @Test
    public void regexFoundFromStringInFile() {
        Utility.ReadXMLFile(fileXmlBooks, regex);
    }
}
