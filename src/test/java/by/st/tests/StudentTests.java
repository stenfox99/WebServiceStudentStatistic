package by.st.tests;

import by.st.dto.StudentsList;
import by.st.rest.StudentController;
import junit.framework.TestCase;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class StudentTests extends TestCase {

    @Test
    public void testGetStudents() throws IOException {
        StudentController studentController = new StudentController();
        ResponseEntity<StudentsList> response = studentController.getStudents();
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testAddStudent(){
        String name = RandomStringUtils.random(5);
        String surname = RandomStringUtils.random(7);
        String dateBirth = RandomStringUtils.random(5);
        StudentController studentController = new StudentController();
        ResponseEntity<String> response = studentController.addStudent(name,surname,dateBirth);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testRemoveStudent(){
        String surname = RandomStringUtils.random(7);
        StudentController studentController = new StudentController();
        ResponseEntity<String> response = studentController.deleteStudent(surname);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}
