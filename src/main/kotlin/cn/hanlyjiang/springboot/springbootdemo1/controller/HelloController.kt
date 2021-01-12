package cn.hanlyjiang.springboot.springbootdemo1.controller

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@EnableAutoConfiguration
class HelloController {

    @RequestMapping("/home")
    fun home(): String {
        return "Hello SpringBoot!!!"
    }
}