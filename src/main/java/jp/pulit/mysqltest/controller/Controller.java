package jp.pulit.mysqltest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image")
public class Controller {

    @PostMapping("/")
    public @ResponseBody String getImageDataWithUID(@RequestParam String uid) {

        return "Success";
    }
}
