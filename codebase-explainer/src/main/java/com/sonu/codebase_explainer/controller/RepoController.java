package com.sonu.codebase_explainer.controller;


import com.sonu.codebase_explainer.model.RepoInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sonu.codebase_explainer.service.GitHubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RepoController {
    private final GitHubService gitHubService;

    public RepoController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/repos/{owner}/{repo}")
    public RepoInfo getRepo(@PathVariable String owner,
                            @PathVariable String repo) {
        return gitHubService.getRepoInfo(owner, repo);
    }

    @GetMapping("/repos/{owner}/{repo}/files")
    public List<String> getFileTree(@PathVariable String owner,
                                    @PathVariable String repo,
                                    @RequestParam String branch) {
        return gitHubService.getRepoFileTree(owner, repo, branch);
    }
}
