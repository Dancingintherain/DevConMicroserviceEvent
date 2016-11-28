package com.senacor.service;

import com.senacor.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by saba on 11.11.16.
 */

@Service
public class UserService {

    final String userUri = "http://localhost:8081/user/";
    RestTemplate restTemplate = new RestTemplate();

    //kommt in den User-Service im User-Microservice bzw. geändert werden
    public User authenticateUser(User user) {
        System.out.println("authenticating user");
        HttpEntity<User> entity = new HttpEntity<>(user);
        ResponseEntity<User> responseEntity= restTemplate.exchange(userUri + "auth", HttpMethod.POST, entity, User.class);
        return responseEntity.getBody();
/*
        ResponseEntity<User> response;
        try{
            System.out.println("in try catch block");
            return restTemplate.exchange(userUri + "auth", HttpMethod.POST, entity, User.class);
        }catch(HttpClientErrorException e){
            e.printStackTrace();
            System.out.println(e.getStatusCode());
            System.out.println(e.getResponseBodyAsString());
            return null;
        }*/

    }
}
