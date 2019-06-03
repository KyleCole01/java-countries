package com.example.demo.controllers

import com.example.demo.repo.CountryList
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CountryNameController {

    @RequestMapping(value = ["/names/all"])
    fun getAllNames(): ResponseEntity<Any> {
        CountryList.countryList.sortBy { country -> country.name }
        return ResponseEntity(CountryList.countryList, HttpStatus.OK)
    }

    @RequestMapping(value = ["/names/start/{letter}"])
    fun getNamesByFirstLetter(@PathVariable letter: Char): ResponseEntity<Any> {
        return ResponseEntity(CountryList.countryList.filter
        { country -> country.name[0] == letter.toUpperCase() }.sortedBy
        { country -> country.name.toUpperCase() }, HttpStatus.OK)
    }


    @RequestMapping(value = ["/names/size/{number}"])
    fun getNamesBySize(@PathVariable number: Long): ResponseEntity<Any> {
        return ResponseEntity(CountryList.countryList.filter { country -> country.name.length >= number }.sortedBy
        { country ->
            country.name
        }, HttpStatus.OK)
    }
}

