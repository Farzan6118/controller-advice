package com.example.demo;

import com.example.demo.dto.studentRequestDto;
import com.example.demo.model.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class studentControllerIntegrationTest {

    private final Gson gson = new Gson();
    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private String serverPort;

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        return headers;
    }

    @BeforeEach
    public void testSaveUser() {
        // Create UserRequest object
        studentRequestDto studentRequestDto = new studentRequestDto();
        studentRequestDto.setName("John Doe");
        studentRequestDto.setEmail("johndoe@example.com");
        studentRequestDto.setMobile("1234567890");
        studentRequestDto.setGender("Male");
        studentRequestDto.setAge(30);
        studentRequestDto.setNationality("American");

        // Send request
        HttpEntity<studentRequestDto> entity = new HttpEntity<>(studentRequestDto, createHeaders());
        ResponseEntity<String> response = restTemplate.postForEntity(
                String.format("http://localhost:%s/api/v1/signup", serverPort),
                entity,
                String.class
        );

        // Assertions
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals("John Doe", response.getBody());
    }

    @Test
    public void testGetAllUsers() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                String.format("http://localhost:%s/api/v1/fetchAll", serverPort),
                String.class
        );

        // Parse response body

        Type listType = new TypeToken<ArrayList<Student>>() {
        }.getType();
        List<Student> students = gson.fromJson(response.getBody(), listType);

        // Assertions
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(students);
        Assertions.assertFalse(students.isEmpty());
    }

    @Test
    public void testGetUserById() {
        // Assuming user with ID 1 exists for this test
        int userId = 1;
        ResponseEntity<String> response = restTemplate.getForEntity(
                String.format("http://localhost:%s/api/v1/%d", serverPort, userId),
                String.class
        );

        // Parse response body
        Student student = gson.fromJson(response.getBody(), Student.class);

        // Assertions
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(student);
        Assertions.assertEquals(1, student.getId());
    }
}
