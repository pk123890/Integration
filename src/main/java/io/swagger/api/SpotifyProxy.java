package io.swagger.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "spotify", url = "https://fluffy-mink.dev.with-datafire.io")
public interface SpotifyProxy {
    @GetMapping("/spotify/get_following")
    String spotifyGetFollowingGet(@RequestParam("type") java.lang.String type);

    @GetMapping("/spotify/user_details")
    String spotifyUserDetailsGet(@RequestParam("user_id") java.lang.String user_id);


}
