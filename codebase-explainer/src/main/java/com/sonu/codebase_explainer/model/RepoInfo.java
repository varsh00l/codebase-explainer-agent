package com.sonu.codebase_explainer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;



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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
