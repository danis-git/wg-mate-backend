package at.jku.wgmatebackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @RequestMapping("/greeting")
    public String getGreetings() {
        return "Hi dani du hast das gschafft";
    }
}
