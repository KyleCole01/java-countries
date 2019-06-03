package com.example.demo.controllers

import com.example.demo.models.Country
import com.example.demo.repo.CountryList
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CountryAgeController {


    @RequestMapping(value = ["/age/all"])
    fun getAllAges(): ResponseEntity<Any> {
        CountryList.countryList.sortBy { country -> country.medianAge }
        return ResponseEntity(CountryList.countryList, HttpStatus.OK)
    }

    // return the countries that have a median age equal to or greater than the given age
    @RequestMapping("/age/{age}")
    fun getCountriesByMedianAge(@PathVariable age: Int): ResponseEntity<Any> {
        val countries = ArrayList<Country>()
        for (country in CountryList.countryList) {
            if (country.medianAge >= age) {
                countries.add(country)
            }
        }

        return ResponseEntity(countries, HttpStatus.OK)
    }

    // return the country with the smallest median age
    @RequestMapping("/age/min")
    fun getCountryWithMinMedianAge(): ResponseEntity<Any> {
        if (CountryList.countryList.size == 0) {
            return ResponseEntity("null", HttpStatus.OK)
        }

        var countryWithMinMedianAge = CountryList.countryList[0]
        var i = 1
        while (i < CountryList.countryList.size) {
            val country = CountryList.countryList[i]
            if (country.medianAge < countryWithMinMedianAge.medianAge) {
                countryWithMinMedianAge = country
            }

            ++i
        }

        return ResponseEntity(countryWithMinMedianAge, HttpStatus.OK)
    }

    // return the country the the greatest median age
    @RequestMapping("/age/max")
    fun getCountryWithMaxMedianAge(): ResponseEntity<Any> {
        if (CountryList.countryList.size == 0) {
            return ResponseEntity("null", HttpStatus.OK)
        }

        var countryWithMaxMedianAge = CountryList.countryList[0]
        var i = 1
        while (i < CountryList.countryList.size) {
            val country = CountryList.countryList[i]
            if (country.medianAge > countryWithMaxMedianAge.medianAge) {
                countryWithMaxMedianAge = country
            }

            ++i
        }

        return ResponseEntity(countryWithMaxMedianAge, HttpStatus.OK)
    }
}