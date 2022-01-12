package com.example.departmentservice.service;

import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {

        log.info("Inside saveDepartment method of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findByDepartmentId(Long departmentId) {

        log.info("Inside getDepartment method of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }


    public List<Department> findAllDepartments() {

        List<Department> departments = departmentRepository.findAll();

        log.info("Inside findAllDepartments method of DepartmentService");
        return departments;
    }

    public Department updateDepartmentById(Long departmentId, Department department) {

      Department departmentToUpdate = departmentRepository.getById(departmentId);

      departmentToUpdate.setDepartmentName(department.getDepartmentName());
      departmentToUpdate.setDepartmentAddress(department.getDepartmentAddress());
      departmentToUpdate.setDepartmentCode(department.getDepartmentCode());

        log.info("Inside updateDepartmentById method of DepartmentService");
      return departmentRepository.save(departmentToUpdate);

    }

    public Department updateDepartmentByName(String departmentName, Department department) {

        Department departmentToUpdate = departmentRepository.findByDepartmentName(departmentName);

        departmentToUpdate.setDepartmentName(department.getDepartmentName());
        departmentToUpdate.setDepartmentAddress(department.getDepartmentAddress());
        departmentToUpdate.setDepartmentCode(departmentToUpdate.getDepartmentCode());

        departmentRepository.save(departmentToUpdate);

        log.info("Inside updateDepartmentByName method of DepartmentService");
        return departmentToUpdate;
    }
}
