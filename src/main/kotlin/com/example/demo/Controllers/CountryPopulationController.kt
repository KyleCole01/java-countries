package com.example.demo.Controllers

import com.example.demo.Models.Country
import com.example.demo.Repo.CountriesList
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CountryPopulationController

@RequestMapping(value = ["/population/median"])
fun getCountryWithMedianPopulation(): ResponseEntity<Any>{
    val listCopy: List<Country> = CountriesList.countryList.sortedBy { country -> country.population }
    return ResponseEntity(listCopy[listCopy.size / 2], HttpStatus.OK)
}
