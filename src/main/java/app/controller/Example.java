package app.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/teste")
    String teste() {
        return "teste!";
    }

    @PreAuthorize("isAnonymous()")
    @RequestMapping("/anonimo")
    String anonimo() {
        return "anonimo";
    }


    /**
     * https://docs.spring.io/spring-security/site/docs/3.0.x/reference/el-access.html
     * @return
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/logado")
    String logado() {
        return "logado!";
    }

}