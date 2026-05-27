package com.sonu.codebase_explainer.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "repos")
public class Repo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String owner;

    @Column(nullable = false)
    private String name;

    private String description;
    private String language;
    private String defaultBranch;

    @Enumerated(EnumType.STRING)
    private IngestionStatus status;

    @OneToMany(mappedBy = "repo", cascade = CascadeType.ALL)
    private List<CodeFile> files;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public IngestionStatus getStatus() {
        return status;
    }

    public void setStatus(IngestionStatus status) {
        this.status = status;
    }

    public List<CodeFile> getFiles() {
        return files;
    }

    public void setFiles(List<CodeFile> files) {
        this.files = files;
    }
}
