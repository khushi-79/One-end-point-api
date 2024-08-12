package com.oneendpointapi.One_end_point_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.springframework.http.HttpMethod.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/handleRequest")
    public ResponseEntity<String> handleRequest(@RequestBody Map<String, Object> requestBody, HttpMethod method) {
        String url;
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody);
        ResponseEntity<String> response;

        if (method.equals(GET)) {
            url = "https://jsonplaceholder.typicode.com/posts/1"; // Example GET API
            response = restTemplate.exchange(url, GET, entity, String.class);
        }
        else if (method.equals(POST)) {
            url = "https://jsonplaceholder.typicode.com/posts"; // Example POST API
            response = restTemplate.exchange(url, POST, entity, String.class);
        }
        else if (method.equals(PUT)) {
            url = "https://jsonplaceholder.typicode.com/posts/1"; // Example PUT API
            response = restTemplate.exchange(url, PUT, entity, String.class);
        }
        else if (method.equals(DELETE)) {
            url = "https://jsonplaceholder.typicode.com/posts/1"; // Example DELETE API
            response = restTemplate.exchange(url, DELETE, entity, String.class);
        }
        else {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Method not allowed");
        }

        return ResponseEntity.ok(response.getBody());
    }
}
