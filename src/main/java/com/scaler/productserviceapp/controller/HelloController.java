package com.scaler.productserviceapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController - This class will be serving REST (http) APIs
//@RequestMapping("/hello") - This class will have multiple methods that will
//be serving HTTP Request at /hello
@RestController
@RequestMapping("/hello")
public class HelloController {

    //GET /hello/say
    //Something written in curly braces, will become a variable
    @GetMapping("/say/{name}/{times}")
    public String sayHello(@PathVariable("name") String name,
                           @PathVariable("times") int times){

        String answer = "";
        for(int i=0; i<times; i++){
            answer = answer + "Hello " + name + " : " + i;
            answer = answer + "<br>";
        }
        return answer;
    }
}
