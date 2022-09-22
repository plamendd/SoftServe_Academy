package jsonparser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JsonParser {
    public  static final  String JSON_FILE = "students.txt";
    public static final  String HIGHER_RANK_STUDENTS = "higherrankstudents.txt";
    public static final  String LOWER_RANK_STUDENTS = "lowerrankstudents.txt";
    public  static final double RANK = 3;



    public static void main(String[] args) {

        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON array to list of students
            List<Student> students = Arrays.asList(mapper.readValue(Paths.get(JSON_FILE).toFile(), Student[].class));

            //creating two list of students with higher and lower than 3 rank.
            List<Student> higherRankStudents = new ArrayList<>();
            List<Student> lowerRankStudents = new ArrayList<>();

            students.stream().forEach(student -> {
                if (student.getRank() >= RANK){
                    higherRankStudents.add(student);
                } else {
                    lowerRankStudents.add(student);
                }
            });

            //writing the content to the specific file.
            mapper.writeValue(Paths.get(HIGHER_RANK_STUDENTS).toFile(), higherRankStudents);
            mapper.writeValue(Paths.get(LOWER_RANK_STUDENTS).toFile(), lowerRankStudents);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
