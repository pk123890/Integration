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
public class TrelloApiController implements TrelloApi {
    @Autowired
    TrelloProxy trelloProxy;


    private static final Logger log = LoggerFactory.getLogger(TrelloApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TrelloApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }



    public ResponseEntity<String> trelloGetBoardNameGet(@ApiParam(value = "") @Valid @RequestParam(value = "idBoard", required = false) java.lang.String idBoard)
{
return new ResponseEntity<String>(trelloProxy.trelloGetBoardNameGet(idBoard), HttpStatus.OK);
}


}
