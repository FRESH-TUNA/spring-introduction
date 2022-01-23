package com.koko.introduction.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");

        //hello.html을 찾아서 랜딩해라
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("data", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(required = false) String name) {
        return "hello-template";
    }

    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    @GetMapping("hello-hohoho")
    @ResponseBody
    public Hello helloHohoho(@RequestParam(required = false) String name) {
        Hello hello = new Hello();
        hello.setName("hohoho");
        return hello;
    }
}

