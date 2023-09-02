package com.example.githubapp.model;

import lombok.Data;

@Data
public class Response {

    private String repositoryName;
    private Owner owner = new Owner();
    private String branches;

    @Data
    public static class Owner {
        private String ownerLogin;
    }
}
