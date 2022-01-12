package com.example.userservice.service;

import com.example.userservice.VO.Department;
import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
       return userRepository.save(user);
    }

    public List<User> getUsers() {
       return userRepository.findAll();
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {

        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);

        responseTemplateVO.setDepartment(department);
        responseTemplateVO.setUser(user);

        return responseTemplateVO;

    }

    public User getUser(Long userId) {
       return userRepository.findByUserId(userId);
    }

    public User getUserByName(String name) {

        return userRepository.findByFirstName(name);
    }
}
