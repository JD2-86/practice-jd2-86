package by.paramonov.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping
    public void echoGet(){
        System.out.println();
    }
    @PostMapping
    public void echoPost(@RequestBody User user){

        System.out.println();
    }
}
