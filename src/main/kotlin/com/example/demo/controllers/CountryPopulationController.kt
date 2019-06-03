package com.example.demo.controllers

import com.example.demo.models.Country
import com.example.demo.repo.CountryList
import com.example.demo.repo.CountryList.countryList
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController

class CountryPopulationController {

    @RequestMapping(value = ["/population/size/{people}"])
    fun getCountryByPopulation(@PathVariable people: Long): ResponseEntity<Any> {
        return ResponseEntity(countryList.filter { country -> country.population >= people }.sortedBy { country ->
            country.population
        }, HttpStatus.OK)
    }

    @RequestMapping(value = ["/population/min"])
    fun getCountryWithSmallestPopulation(): ResponseEntity<Any> {
        return ResponseEntity(countryList.minBy { country -> country.population }, HttpStatus.OK)
    }

    @RequestMapping(value = ["/population/max"])
    fun getCountryWithLargestPopulation(): ResponseEntity<Any> {
        return ResponseEntity(countryList.maxBy { country -> country.population }, HttpStatus.OK)
    }
}