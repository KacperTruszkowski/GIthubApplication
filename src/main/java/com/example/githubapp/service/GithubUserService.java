package com.example.githubapp.service;

import com.example.githubapp.model.GithubRepository;
import com.example.githubapp.model.GithubRequest;
import com.example.githubapp.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GithubUserService {

    private static final String GITHUB_URL = "https://api.github.com/users/";
    private static final String REPOS_URL = "/repos";
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Response> getUserRepositories(GithubRequest request) {
        ResponseEntity<List<GithubRepository>> responseEntity = restTemplate.exchange(
                GITHUB_URL + request.getUserName() + REPOS_URL, HttpMethod.GET, null, new ParameterizedTypeReference<>() {}
        );
        List<GithubRepository> repositories = responseEntity.getBody();
        return repositories.stream()
                .filter(repository -> !repository.isFork())
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private Response mapToResponse(GithubRepository repository) {
        Response response = new Response();
        response.setRepositoryName(repository.getName());
        response.getOwner().setOwnerLogin(repository.getOwner().getLogin());
        response.setBranches(repository.getBranches_url());
        return response;
    }
}

