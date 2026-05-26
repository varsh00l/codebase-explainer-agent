package com.sonu.codebase_explainer.service;
import com.sonu.codebase_explainer.model.RepoInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

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
}
