package io.swagger.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = github, url = "https://fluffy-mink.dev.with-datafire.io/")
public interface GithubProxy {
    @GetMapping(/github/create_repository){
    String githubCreateRepositoryGet(java.lang.String body);
    }
@GetMapping(/github/create_repository){
    String githubGetRepositoryGet();
    }
@GetMapping(/github/create_repository){
    String githubUserDetailsGet();
    }

}
