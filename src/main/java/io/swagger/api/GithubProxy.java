package io.swagger.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "github", url = "https://fluffy-mink.dev.with-datafire.io/github")
public interface GithubProxy {
    @GetMapping("/user_details")
    String githubUserDetailsGet();

    @GetMapping("/get_repository")
    String githubGetRepositoryGet();

    @GetMapping("/create_repository")
    String githubCreateRepositoryGet(@RequestParam("body") String body);


}
