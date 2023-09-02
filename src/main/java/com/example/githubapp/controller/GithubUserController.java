package com.example.githubapp.controller;

import com.example.githubapp.model.GithubRequest;
import com.example.githubapp.model.Response;
import com.example.githubapp.service.GithubUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GithubUserController {

    private final GithubUserService githubUserService;

    @PostMapping("/getRepo")
    public ResponseEntity<?> getUserRepository(@RequestBody GithubRequest request) {
        try {
            List<Response> responses = githubUserService.getUserRepositories(request);
            return ResponseEntity.ok(responses);
        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }
}
