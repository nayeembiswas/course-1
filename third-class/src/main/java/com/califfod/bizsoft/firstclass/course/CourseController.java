package com.califfod.bizsoft.firstclass.course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository repository;

    @PostMapping("create")
    public String create(@RequestBody Course course){
        repository.save(course);
        return "Successfully saved";
    }

    @PutMapping("update")
    public String update(@RequestBody Course course){
        repository.save(course);
        return "Successfully update";
    }

    @GetMapping("get-all")
    public List<Course> getAll(){
        return repository.findAll();
    }

    @GetMapping("get-by-id/{id}")
    public Course getById(@PathVariable("id") Integer id) throws Exception {
        return repository.findById(id).orElse(new Course());
    }

    @DeleteMapping("delete-by-id/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        repository.deleteById(id);
        return "Successfully Deleted";
    }
}
