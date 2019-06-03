package com.example.demo

import com.example.demo.repo.CountryList
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

var countryList: CountryList = CountryList

fun main(args: Array<String>){
    runApplication<DemoApplication>(*args)
}