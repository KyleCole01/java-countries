package com.example.demo.Controllers

import com.example.demo.Models.Country
import com.example.demo.Repo.CountriesList
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CountryPopulationController

// return the country with the smallest population
@RequestMapping("/population/min")
fun getCountryWithMinPop(): Country? {
    if (CountriesList.countryList.size == 0) {
        return null
    }

    var countryWithMinPop = CountriesList.countryList[0]

    var i = 1
    while (i < CountriesList.countryList.size) {
        val country = CountriesList.countryList[i]
        if (country.population < countryWithMinPop.population) {
            countryWithMinPop = country
        }

        ++i
    }

    return countryWithMinPop
}

// return the country with the largest population
@RequestMapping("/population/max")
fun getCountryWithMaxPop(): Country? {
    if (CountriesList.countryList.size == 0) {
        return null
    }

    var countryWithMaxPop = CountriesList.countryList[0]

    var i = 1
    while (i < CountriesList.countryList.size) {
        val country = CountriesList.countryList[i]
        if (country.population > countryWithMaxPop.population) {
            countryWithMaxPop = country
        }

        ++i
    }

    return countryWithMaxPop
}
