package io.swagger.api;

import io.swagger.DTO.Response;
import io.swagger.DTO.ResponseFollowing;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spotify",url = "https://fluffy-mink.dev.with-datafire.io/spotify")
public interface SpotifyProxy {
    @GetMapping("user_details")
    String spotifyUserDetailsGet(@RequestParam("user_id") String user_id);
    @GetMapping("get_following")
    String spotifyGetFollowingGet(@RequestParam("type") String type);
}
