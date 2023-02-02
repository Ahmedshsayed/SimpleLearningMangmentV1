import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Main {

    public static void main(String... args) throws IOException, SAXException, ParseException {

        //TextFileReaderandexport textFileReaderandexport = new TextFileReaderandexport();
        //textFileReaderandexport.selecttextfile();
        //textFileReaderandexport.csvfileexport();
        //XmlFileReader xml = new XmlFileReader();2
        //xml.selectxmlfile();
        //xml.xmlfileexport();
        //PrintStudentData PD = new PrintStudentData();
        //PD.printfunction();
        JsonStudentcoursedetails JsonStudentcoursedetails = new JsonStudentcoursedetails ();
        JsonStudentcoursedetails.Jsonreader();
        JsonStudentcoursedetails.gettingdataafterfilter();


    }
}