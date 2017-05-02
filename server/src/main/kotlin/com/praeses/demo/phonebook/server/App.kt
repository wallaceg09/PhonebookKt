package com.praeses.demo.phonebook.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Created by Glen on 5/1/2017.
 */
@SpringBootApplication
open class App

fun main(args:Array<String>) {
    SpringApplication.run(App::class.java, *args)
}
