import java.io.*;
import java.util.Scanner;

public class TextFileReaderandexport {
    public File file ;
    public Scanner sc;
    public String data ;
    String[] dataafteredit = null;
    File filecsv ;
    String [] dataofstudent ;



    public String [] selecttextfile () throws IOException {

         file = new File("src/files/student-data.txt");
         sc = new Scanner(file);
        while ((sc.hasNextLine())) {
            data = sc.nextLine().replace("#", ",");
            data = data.replace("$", "\n");
            dataafteredit=data.split("\n");
            //System.out.println(data);
        }
        return dataafteredit;

    }

        public void csvfileexport () throws IOException {
             dataofstudent = selecttextfile();

             filecsv = new File("src/files/student-data.csv");
            FileWriter fileWriter = new FileWriter(filecsv);
            for (String student : dataofstudent) {
                StringBuilder splite = new StringBuilder();
                splite.append(student);
                splite.append("\n");
                fileWriter.write(splite.toString());
            }
            fileWriter.close();

        }

    }

