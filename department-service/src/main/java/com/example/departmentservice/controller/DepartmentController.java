package com.example.departmentservice.controller;

import com.example.departmentservice.entity.Department;
import com.example.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment method of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findByDepartmentId(@PathVariable("id") Long departmentId) {

        log.info("Inside getDepartment method of DepartmentController");
        return departmentService.findByDepartmentId(departmentId);
    }

    @GetMapping("/")
    public List<Department> findAllDepartments() {

        List<Department> departments = departmentService.findAllDepartments();

        log.info("Inside findAllDepartments method of DepartmentController");
        return departments;
    }


    @PutMapping("/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department) {

        log.info("Inside updateDepartmentById method of DepartmentController");
        return departmentService.updateDepartmentById(departmentId, department);
    }


    @PutMapping("/{name}")
    public Department updateDepartmentByName(@PathVariable("name") String departmentName, @RequestBody Department department) {

        log.info("Inside updateDepartmentByName method of DepartmentController");
        return departmentService.updateDepartmentByName(departmentName, department);
    }



}
