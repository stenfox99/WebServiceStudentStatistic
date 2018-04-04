package by.st.dto;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"students"})
@XmlRootElement(name = "Students_list")
public class StudentsList {

    @XmlElement(name = "Student")
    private List<Student> students;

    public StudentsList(){
        students = new ArrayList<Student>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void deleteStudent(String surname){
        Student studentForDeleted = null;
        for (Student student : students){
            if (student.getSurname().equals(surname))
                studentForDeleted = student;
        }
        students.remove(studentForDeleted);
    }
}
