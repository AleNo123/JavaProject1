plugins {
    id("java")
    id("application")
}
tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes(
                "Main-Class" to "org.example.Main"
        )
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })

}
tasks {
    withType<Copy> {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
    withType<JavaCompile>{
        options.encoding = "UTF-8"
    }
}
//configurations {
//    // configuration that holds jars to include in the jar
//    named("extraLibs")
//}
application {
    mainClass.set("org.example.Main")
}
sourceSets{
    main{
        resources{
            srcDirs("src/main/resources")
        }
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

//compileJava.options.encoding = "UTF-8"
//
//tasks.withType(JavaCompile) {
//    options.encoding = "UTF-8"
//}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
repositories {
    mavenCentral()
}
dependencies {
    implementation("org.apache.logging.log4j:log4j-api:2.21.1")
    runtimeOnly("org.apache.logging.log4j:log4j-core:2.21.1")
    implementation("com.alibaba:fastjson:2.0.32")
}
tasks.test {
    useJUnitPlatform()
}