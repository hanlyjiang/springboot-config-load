import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.3.9.RELEASE"
    // nacos 暂不支持2.4+
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter
//    id("org.springframework.boot") version "2.4.1"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    kotlin("jvm") version "1.4.21"
    kotlin("plugin.spring") version "1.4.21"
}

group = "cn.hanlyjiang.springboot"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-web-services")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    // nacos配置管理
    implementation("com.alibaba.boot:nacos-config-spring-boot-starter:0.2.7")
    // nacos服务发现
    implementation("com.alibaba.boot:nacos-discovery-spring-boot-starter:0.2.7")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// 拷贝生成物到docker目录
tasks.create("prepareJarForDocker", Copy::class) {
    println("创建任务：$name")

    dependsOn("bootJar")
    group = "docker"

    from(File(project.buildDir, "libs"))
    destinationDir = File(projectDir, "docker")

    doLast {
        println("复制文件jar文件完成")
    }
}