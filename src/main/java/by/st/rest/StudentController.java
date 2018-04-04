package by.st.rest;

import by.st.dto.Student;
import by.st.dto.StudentsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statistic")
public class StudentController {

    @Autowired
    private StudentsList students;

    @RequestMapping(value = "/getStudents", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<StudentsList> getStudents() {
        return new ResponseEntity<StudentsList>(students, HttpStatus.OK);
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addStudent(@RequestParam("name")String name,
                                             @RequestParam("surname")String surname,
                                             @RequestParam("dateBirth")String dateBirth){
        Student student = new Student(name,surname,dateBirth);
        students.addStudent(student);
        return new ResponseEntity<String>("The student was added to the list",HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deleteStudent(@RequestParam("surname")String surname){
        students.deleteStudent(surname);
        return new ResponseEntity<String>("The student was deleted from list",HttpStatus.OK);
    }
}
