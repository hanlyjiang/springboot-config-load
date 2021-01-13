package cn.hanlyjiang.springboot.springbootdemo1.controller

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@EnableAutoConfiguration
class HelloController {

    @RequestMapping("/home")
    fun home(): String {
        return "Hello SpringBoot !!!"
    }

    // rest-service: https://spring.io/guides/gs/rest-service/
    @RequestMapping("/name")
    fun home(@RequestParam(value = "name", defaultValue = "没有名字") name: String):Greeting {
        return Greeting(Math.random().toInt(), name)
    }

    data class Greeting(val id: Int, val value: String)
}