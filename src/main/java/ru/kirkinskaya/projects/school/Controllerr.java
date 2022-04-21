package ru.kirkinskaya.projects.school;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/go")
public class Controllerr {

    @RequestMapping("/hello")
    @ResponseBody
    public String getHello(){
        return "Hello world";
    }

    @RequestMapping("/gb")
    @ResponseBody
    public String getGb(){
        return "gb world";
    }
}
