package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/ivan")
    public String ivanAction() {
        return "ivan";
    }
    @RequestMapping("/petr")
    public String petrAction() {
        return "petr";
    }
    @RequestMapping("/pavel")
    public String pavelAction() {
        return "pavel";
    }
}
