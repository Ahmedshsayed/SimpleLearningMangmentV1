import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlFileReader {

    public List<String> selectxmlfile() {

        File XmlFile = new File("src/files/coursedata.xml");

        List<String> coursesList = new ArrayList<>();
        DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
        try {
            DBF.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder DB = DBF.newDocumentBuilder();
            Document DOC = DB.parse(new File(XmlFile.toURI()));
            DOC.getDocumentElement().normalize();
            NodeList list = DOC.getElementsByTagName("row");
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String id = element.getElementsByTagName("id").item(0).getTextContent();
                    String courseName = element.getElementsByTagName("CourseName").item(0).getTextContent();
                    String instructor = element.getElementsByTagName("Instructor").item(0).getTextContent();
                    String courseDuration = element.getElementsByTagName("CourseDuration").item(0).getTextContent();
                    String location = element.getElementsByTagName("Location").item(0).getTextContent();
                    String courseTime = element.getElementsByTagName("CourseTime").item(0).getTextContent();
                    coursesList.add(id + "," + courseName + "," + instructor + "," + courseDuration + "," + courseTime
                            + "," + location);
                    //System.out.println("id,CourseName,Instructor,CourseDuration,CourseTime,Location");
                    //System.out.println(id + "," + courseName + "," + instructor + "," + courseDuration + "," + courseTime
                           // + "," + location);
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
        return coursesList;
    }

    public void xmlfileexport () throws IOException {
        List<String> allcourses = selectxmlfile();

        File file = new File("src/files/coursedata.csv");
        FileWriter fileWriter = new FileWriter(file);
        for (String courses : allcourses) {
            StringBuilder line = new StringBuilder();
            line.append(courses);
            line.append("\n");
            fileWriter.write(line.toString());
        }
        fileWriter.close();


    }
}



