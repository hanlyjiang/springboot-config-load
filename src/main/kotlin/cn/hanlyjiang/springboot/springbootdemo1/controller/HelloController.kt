package cn.hanlyjiang.springboot.springbootdemo1.controller

import cn.hanlyjiang.springboot.springbootdemo1.config.DBConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@EnableAutoConfiguration
class HelloController {

    @Autowired
    lateinit var dbConfig: DBConfig

    @RequestMapping("/home")
    fun home(): String {
        return "Hello SpringBoot !!!"
    }

    // rest-service: https://spring.io/guides/gs/rest-service/
    @RequestMapping("/name")
    fun home(@RequestParam(value = "name", defaultValue = "没有名字") name: String): Greeting {
        return Greeting(Math.random().toInt(), name)
    }

    @RequestMapping("/config", method = [RequestMethod.GET])
    fun config(): DBConfig {
        return dbConfig
    }

    data class Greeting(val id: Int, val value: String)
}