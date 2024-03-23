package com.califfod.bizsoft.firstclass.student;

import com.califfod.bizsoft.firstclass.user.User;
import com.califfod.bizsoft.firstclass.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
        student.setUserId(user.getId());
        studentRepository.save(student);
    }
}
