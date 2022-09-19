import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.print.Book;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonParser {
    public static void main(String[] args) {
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON array to list of students
            List<Student> students = Arrays.asList(mapper.readValue(Paths.get("students.txt").toFile(), Student[].class));

            //creating two list of students with higher and lower than 3 rank.
            List<Student> higherRankStudents = new ArrayList<>();
            List<Student> lowerRankStudents = new ArrayList<>();

            students.stream().forEach(student -> {
                if (student.getRank() > 3){
                    higherRankStudents.add(student);
                } else {
                    lowerRankStudents.add(student);
                }
            });

            mapper.writeValue(Paths.get("higherrankstudents.txt").toFile(), higherRankStudents);
            mapper.writeValue(Paths.get("lowerrankstudents.txt").toFile(), lowerRankStudents);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
