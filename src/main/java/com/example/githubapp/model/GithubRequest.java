package com.example.githubapp.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GithubRequest {

    @NotNull
    private String userName;
}
