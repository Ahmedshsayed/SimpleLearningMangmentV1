import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JsonStudentcoursedetails {
    String number;

    public String Jsonreader() {
        System.out.println("Please enter The Student ID");
        Scanner Sc = new Scanner(System.in);
        String input = Sc.nextLine();
        number = input;
        JSONParser jsonParser = new JSONParser();
        try (FileReader readerj = new FileReader("src/files/jsonStudentid.json")) {
            Object object = jsonParser.parse(readerj);
            JSONObject json_data = (JSONObject) object;
            for (Object object1 : json_data.keySet()) {
                //System.out.println(o);
                if (object1.equals(number)) {
                    //System.out.println(json_data.get(o));
                    return json_data.get(object1).toString();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void gettingdataafterfilter() throws FileNotFoundException {
        // parsing a CSV file into Scanner class constructor

        String courses = Jsonreader();
        System.out.println("Student Details page");
        System.out.println("====================================================================================");

        Scanner sc = new Scanner(new File("src/files/student-data.csv"));
        sc.useDelimiter(","); // sets the delimiter pattern
        while (sc.hasNext()) // returns a boolean value
        {
            String line = sc.nextLine();
            String id = line.split(",")[0];
            String name = line.split(",")[1];
            String grade = line.split(",")[2];
            String email = line.split(",")[3];
            if (id.equals(number)) {
                System.out.println("Name: " + name + "  " + "Grade: " + grade + "  " + "E-mail: " + email);
                break;

            }
        }
        sc.close(); // closes the scanner
        System.out.print("-----------------------------------------------------------------");
        System.out.println();
        Scanner scCourses = new Scanner(new File("src/files/coursedata.csv"));
        scCourses.useDelimiter(","); // sets the delimiter pattern
        System.out.println("Enrolled courses");

        while (scCourses.hasNext()) // returns a boolean value
        {
            String allcourses = scCourses.nextLine();
            String id = allcourses.split(",")[0];
            String name = allcourses.split(",")[1];
            String Instructor = allcourses.split(",")[2];
            String duration = allcourses.split(",")[3];
            String time = allcourses.split(",")[4];
            String Location = allcourses.split(",")[5];


           if (courses.contains(id)) {
              System.out.println(id + "," + name + "," + Instructor + "," + duration + "," + time + "," + Location + ",");

            }

        }


        System.out.println("-----------------------------------------------------------------");
        scCourses.close(); // closes the scanner

    }

}
