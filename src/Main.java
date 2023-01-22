import org.xml.sax.SAXException;

import java.io.IOException;

public class Main {

    public static void main(String... args) throws IOException, SAXException {

        TextFileReaderandexport textFileReaderandexport = new TextFileReaderandexport();
        textFileReaderandexport.selecttextfile();
        textFileReaderandexport.csvfileexport();
        XmlFileReader xml = new XmlFileReader();
        xml.selectxmlfile();
        xml.xmlfileexport();
        PrintStudentData PD = new PrintStudentData();
        PD.printfunction();


    }
}