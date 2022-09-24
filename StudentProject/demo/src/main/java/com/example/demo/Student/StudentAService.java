package com.example.demo.Student;

import org.apache.naming.factory.SendMailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentAService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentAService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists){
            throw new IllegalStateException("student with id "+ studentId + "does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String surname, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(()-> new IllegalStateException("student with id"+studentId+"does not exist"));
        if(name != null && name.length() > 0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(surname !=null && surname.length() > 0 && !Objects.equals(student.getSurname(),surname)){
            student.setSurname(surname);
        }

        if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }

    }
    public Optional<Student> getStudentById(Long studentId) {
        boolean IdExist = studentRepository.existsById(studentId);
        if(!IdExist){
            throw new IllegalStateException("This student does not exist");
        }
        return studentRepository.findById(studentId);
    }
}
