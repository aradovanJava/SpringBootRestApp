package hr.tvz.wauj.vjezbe.app.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello-world")
public class HelloWorldController {
    
    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }
    
}
