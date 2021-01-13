package cn.hanlyjiang.springboot.springbootdemo1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.core.env.PropertySource

@SpringBootApplication
class SpringbootDemo1Application {

}

fun main(args: Array<String>) {
    runApplication<SpringbootDemo1Application>(*args)
}
