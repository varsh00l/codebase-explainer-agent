package com.sonu.codebase_explainer.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sonu.codebase_explainer.service.GitHubService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")
public class RepoController {
    private final GitHubService gitHubService;

    public RepoController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/repos/{owner}/{repo}")
    public String getRepo(@PathVariable String owner,
                          @PathVariable String repo) {
        return gitHubService.getRepoInfo(owner, repo);
    }

}
