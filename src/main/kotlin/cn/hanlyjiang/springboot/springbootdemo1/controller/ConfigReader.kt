package cn.hanlyjiang.springboot.springbootdemo1.controller

import cn.hanlyjiang.springboot.springbootdemo1.config.AppConfig
import com.alibaba.nacos.api.annotation.NacosInjected
import com.alibaba.nacos.api.config.annotation.NacosValue
import com.alibaba.nacos.api.naming.NamingService
import com.alibaba.nacos.api.naming.pojo.Instance
import org.apache.tomcat.util.json.JSONParser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.*
import java.util.*


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

    /*
    nacos 配置管理
     */
    @NacosValue(value = "\${useLocalCache:false}", autoRefreshed = true)
    private val useLocalCache = false

    @RequestMapping(value = ["/getCacheConfig"], method = [RequestMethod.GET])
    @ResponseBody
    fun get(): Boolean {
        return useLocalCache
    }


    /*
    nacos服务发现
     */
    @NacosInjected
    private lateinit var namingService: NamingService

    // curl -v http://localhost:8080/config/getNacoService?serviceName=example
    // curl -X PUT 'http://127.0.0.1:8848/nacos/v1/ns/instance?serviceName=example&ip=127.0.0.1&port=8080'
    @RequestMapping(value = ["/getNacoService"], method = [RequestMethod.GET])
    @ResponseBody
    fun getNacoService(@RequestParam serviceName: String): List<Instance> {
        return namingService.getAllInstances(serviceName);
    }
}