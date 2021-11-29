package com.itcolleg.spring.data.jpa.tutorial.repository;

import com.itcolleg.spring.data.jpa.tutorial.entity.Guardian;
import com.itcolleg.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("aleks@gmail.com")
                .firstName("Aleks")
                .lastName("Preko")
//                .guardianName("Nikhil")
//                .guardianEmail("nikhil@gmail.com")
//                .guardianMobile("9999999999")
                .build();

        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Nikhil")
                .email("nikhil@gmail.com")
                .mobile("12345678")
                .build();

        Student student = Student.builder()
                .firstName("Shivam")
                .emailId("shivam@gmail.com")
                .lastName("Kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Studentenliste: "+studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Aleks");
        System.out.println("Studenten: "+students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("Shiv");
        System.out.println("Studenten: "+students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Nikhil");
        System.out.println("Studenten: "+students);
    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student student = studentRepository
                .getStudentByEmailAddress("aleks@gmail.com");
        System.out.println("Student: "+ student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String firstName = studentRepository
                .getStudentFirstNameByEmailAddress("shivam@gmail.com");
        System.out.println("Firstname: "+firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student = studentRepository
                .getStudentByEmailAddressNative("aleks@gmail.com");
        System.out.println("Student: "+student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository
                .getStudentByEmailAddressNativeNamedParam("shivam@gmail.com");
        System.out.println("Student: "+student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "Aleks Mod",
                "aleks@gmail.com");
    }
}