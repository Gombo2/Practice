package com.ohgiraffers.fuck;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuckController {

    @GetMapping
    public String fuck() {
        return "Fuck";
    }


    @GetMapping("/fuck/{fuckId}")
    public String fuckByFuckId(@PathVariable("fuckId") int fuckId) {
        return "Fuck " + fuckId;
    }

}
