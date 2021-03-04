package cn.hanlyjiang.springboot.springbootdemo1.controller

import cn.hanlyjiang.springboot.springbootdemo1.config.AppConfig
import com.fasterxml.jackson.databind.util.JSONPObject
import org.apache.tomcat.util.json.JSONParser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.LinkedHashMap

/**
 * 配置获取
 * @author hanlyjiang 2021/1/13 11:16 上午
 * @version 1.0
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/config")
class ConfigReader {
    @Autowired
    lateinit var appConfig: AppConfig

    @RequestMapping("", method = [RequestMethod.GET])
    fun config(): AppConfig {
        return appConfig
    }

    @RequestMapping("/jwt_token", method = [RequestMethod.GET])
    fun jwtToken(): LinkedHashMap<String, Any>? {
        return JSONParser(appConfig.jwtSecret).parseObject()
    }


}