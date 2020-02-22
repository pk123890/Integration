/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.14).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-22T08:27:42.466Z[GMT]")
@Api(value = "spotify", description = "the spotify API")
public interface SpotifyApi {

    @ApiOperation(value = "", nickname = "spotifyGetFollowingGet", notes = "Auto generated using Swagger Inspector", response = String.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Auto generated using Swagger Inspector", response = String.class) })
    @RequestMapping(value = "/spotify/get_following",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> spotifyGetFollowingGet(@ApiParam(value = "") @Valid @RequestParam(value = "type", required = false) String type);


    @ApiOperation(value = "", nickname = "spotifyUserDetailsGet", notes = "Auto generated using Swagger Inspector", response = String.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Auto generated using Swagger Inspector", response = String.class) })
    @RequestMapping(value = "/spotify/user_details",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> spotifyUserDetailsGet(@ApiParam(value = "") @Valid @RequestParam(value = "user_id", required = false) String userId);

}
