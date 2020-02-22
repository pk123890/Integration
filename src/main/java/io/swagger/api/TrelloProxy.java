package io.swagger.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "trello", url = "https://fluffy-mink.dev.with-datafire.io")
public interface TrelloProxy {
    @GetMapping("/trello/get_board_name")
    String trelloGetBoardNameGet(@RequestParam("idBoard")java.lang.String idBoard);


}
