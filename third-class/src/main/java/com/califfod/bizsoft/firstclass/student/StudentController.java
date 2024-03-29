package com.califfod.bizsoft.firstclass.student;

import com.califfod.bizsoft.firstclass.user.User;
import com.califfod.bizsoft.firstclass.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/create")
    @Transactional
    public void createStudent(@RequestBody User user){
        user = userRepository.save(user);

        Student student = new Student();
        student.setName(user.getName());
        student.setUser(user);
        student.setCreateOn(new Date());
        studentRepository.save(student);
    }

    @PutMapping("/update")
    @Transactional
    public void updateStudent(@RequestBody User user) throws Exception {
        if(user.getId() == null){
            throw new Exception("Id Not Found");
        }
        Optional<User> userOptional = userRepository.findById(user.getId());
        if(userOptional.isEmpty()){
            throw new Exception("Wrong Id");
        }
        user = userRepository.save(user);

        Optional<Student> optionalStudent = studentRepository.findByUserId(user.getId());

        if(optionalStudent.isEmpty()){
            throw new Exception("No Student found with this id");
        }

        Student student = optionalStudent.get();
        student.setName(user.getName());
        student.setUpdateOn(new Date());
        studentRepository.save(student);
    }
}
