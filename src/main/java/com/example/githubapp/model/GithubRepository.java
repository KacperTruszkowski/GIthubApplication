package com.example.githubapp.model;

import lombok.Data;

@Data
public class GithubRepository {

    private String name;
    private Owner owner;
    private String branches_url;
    private boolean fork;

    @Data
    public static class Owner {
        private String login;
    }
}
