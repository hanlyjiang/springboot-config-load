package cn.hanlyjiang.springboot.springbootdemo1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.core.env.PropertySource

@SpringBootApplication
class SpringbootDemo1Application {

}

fun main(args: Array<String>) {
//    System.setProperty("javax.net.ssl.trustStore","/Library/Java/JavaVirtualMachines/jdk-14.0.2.jdk/Contents/Home/lib/security/cacerts");
//    System.setProperty("javax.net.ssl.trustStore","/Users/hanlyjiang/Wksp/personal/learn/springboot/springboot-demo1/https/cacerts");
//    System.setProperty("javax.net.ssl.trustStorePassword","123456");
    runApplication<SpringbootDemo1Application>(*args)
}
