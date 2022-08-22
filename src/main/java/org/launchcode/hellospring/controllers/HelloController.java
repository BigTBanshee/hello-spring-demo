package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    handles requests of the form /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //now lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //handles requests of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    public String helloWithQueryParam(@RequestParam String name) {
//
//        return "Hello, " + name + "!";
//    }

    //handles requests in the form of /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {

        return "Hello, " + name + "!";
    }
    //   /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action= 'hello' method='post'>" + // submit a request to /hello
                "<input type='text' name='name'>" +
                "<label for='language'/>" +
                "<select name='language' id='language-select'>" +
                "<option value=''>Please select a language</option>" +
                "<option value='english'>English</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='french'>French</option>" +
                "<option value='german'>German</option>" +
                "<option value='italian'>Italian</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }


    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String createMessage(@RequestParam String name, @RequestParam String language) {
        String greeting = "";

        if(Objects.nonNull(language) && language.equals("english"))
            greeting = "Hello";
        else if(Objects.nonNull(language) && language.equals("spanish"))
            greeting = "Holla";
        else if(Objects.nonNull(language) && language.equals("french"))
            greeting = "Bonjour";
        else if(Objects.nonNull(language) && language.equals("german"))
            greeting = "Hallo";
        else if(Objects.nonNull(language) && language.equals("italian"))
            greeting = "Ciao";
        else
            greeting = "Hello";

        return greeting +" , " + name + "!";


        }


}
