import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PrintStudentData extends TextFileReaderandexport {
    TextFileReaderandexport tx = new TextFileReaderandexport();


    public void printfunction() throws IOException {
        System.out.printf("-------------------------------\n");
        System.out.printf("Current Student List\n");
        System.out.printf("-------------------------------\n");
        //System.out.printf("%6s%16s%25s%40s%20s%20s%20s\n", "id", "Name", "grade", "email", "address", "region", "country");
        filecsv = new File("src/files/student-data.csv");
        BufferedReader reader = null;
        String line ="" ;

                try {
                    reader = new BufferedReader(new FileReader(filecsv));
                    while ((line = reader.readLine()) !=null ){
                        String [] row =line.split(",");
                        for (String index : row)
                        {
                            //String row1 = Arrays.toString(row);
                            System.out.printf("%-10s",index);
                        }
                        System.out.println();
                    }
                    reader.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        }



