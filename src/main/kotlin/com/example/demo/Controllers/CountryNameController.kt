package com.example.demo.Controllers

import com.example.demo.Repo.CountriesList
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/country"])
class CountryNameController {

    @RequestMapping(value = ["/names/all"])
    fun getAllNames(): ResponseEntity<Any> {
        CountriesList.countryList.sortBy { country -> country.name }
        return ResponseEntity(CountriesList.countryList, HttpStatus.OK)
    }

    @RequestMapping(value = ["/names/start/{letter}"])
    fun getNamesByFirstLetter(@PathVariable letter: Char): ResponseEntity<Any> {
        return ResponseEntity(CountriesList.countryList.filter
        { country -> country.name.get(0) == letter }.sortedBy
        { country -> country.name }, HttpStatus.OK)
    }


    @RequestMapping(value = ["/names/size/{number}"])
    fun getNamesBySize(@PathVariable number: Long): ResponseEntity<Any> {
        return ResponseEntity(CountriesList.countryList.filter { country -> country.name.length >= number }.sortedBy
        { country ->
            country.name
        }, HttpStatus.OK)
    }
}

