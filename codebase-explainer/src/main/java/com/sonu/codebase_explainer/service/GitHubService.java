package com.sonu.codebase_explainer.service;
import com.sonu.codebase_explainer.model.GitTreeResponse;
import com.sonu.codebase_explainer.model.GitTreeItem;
import com.sonu.codebase_explainer.model.RepoInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GitHubService {
    private final WebClient webClient;

    public GitHubService(WebClient gitHubWebClient) {
        this.webClient = gitHubWebClient;
    }

    public RepoInfo getRepoInfo(String owner, String repo) {
        return webClient.get()
                .uri("/repos/{owner}/{repo}", owner, repo)// path after the base URL.
                .retrieve()
                .bodyToMono(RepoInfo.class)
                .block();
    }
    public List<String> getRepoFileTree(String owner, String repo, String branch) {
        return webClient.get()
                .uri("/repos/{owner}/{repo}/git/trees/{branch}?recursive=1",
                        owner, repo, branch)
                .retrieve()
                .bodyToMono(GitTreeResponse.class)
                .block()
                .getTree()
                .stream()
                .filter(item -> item.getType().equals("blob"))
                .filter(item -> isCodeFile(item.getPath()))
                .map(GitTreeItem::getPath)
                .collect(Collectors.toList());
    }

    private boolean isCodeFile(String path) {
        return path.endsWith(".java") || path.endsWith(".py") ||
                path.endsWith(".ts") || path.endsWith(".js") ||
                path.endsWith(".go") || path.endsWith(".cpp") ||
                path.endsWith(".c") || path.endsWith(".rs");
    }
}
