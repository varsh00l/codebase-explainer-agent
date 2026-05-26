package com.sonu.codebase_explainer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class RepoInfo {
    private String name;

    @JsonProperty("full_name")
    private String fullName;

    private String description;

    private String language;

    @JsonProperty("default_branch")
    private String defaultBranch;

    @JsonProperty("stargazers_count")
    private int stars;

}
