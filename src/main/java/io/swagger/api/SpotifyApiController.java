package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-17T10:46:18.555Z[GMT]")
@Controller
public class SpotifyApiController implements SpotifyApi {
    @Autowired
    SpotifyProxy spotifyProxy;


    private static final Logger log = LoggerFactory.getLogger(SpotifyApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SpotifyApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }



    public ResponseEntity<String> spotifyGetFollowingGet(@ApiParam(value = "") @Valid @RequestParam(value = "type", required = false) java.lang.String type)
{
return new ResponseEntity<String>(spotifyProxy.spotifyGetFollowingGet(type), HttpStatus.OK);
}

public ResponseEntity<String> spotifyUserDetailsGet(@ApiParam(value = "") @Valid @RequestParam(value = "user_id", required = false) java.lang.String user_id)
{
return new ResponseEntity<String>(spotifyProxy.spotifyUserDetailsGet(user_id), HttpStatus.OK);
}


}
