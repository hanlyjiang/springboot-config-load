package cn.hanlyjiang.springboot.springbootdemo1.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class DBConfig {

    @Value("\${db.username}")
    lateinit var username: String

    @Value("\${db.password}")
    lateinit var password: String
}
