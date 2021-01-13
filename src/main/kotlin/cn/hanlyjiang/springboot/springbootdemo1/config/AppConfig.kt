package cn.hanlyjiang.springboot.springbootdemo1.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

/**
 * APP 配置
 */
@Component
class AppConfig {

    @Value("\${db.username}")
    lateinit var dbUsername: String

    @Value("\${db.password}")
    lateinit var dbPassword: String

}
