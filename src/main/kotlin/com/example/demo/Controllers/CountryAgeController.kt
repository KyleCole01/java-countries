package com.example.demo.Controllers

import com.example.demo.Models.Country
import com.example.demo.Repo.CountriesList
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CountryAgeController


@RequestMapping(value = "/age/all")
fun getAllCountries():ArrayList<Country>{
    return ArrayList()
}

// return the countries that have a median age equal to or greater than the given age
@RequestMapping("/age/age")
fun getCountriesByMedianAge(@RequestParam("age") age: Int): ArrayList<Country> {
    val countries = ArrayList<Country>()
    for (country in CountriesList.countryList) {
        if (country.medianAge >= age) {
            countries.add(country)
        }
    }

    return countries
}

// return the country with the smallest median age
@RequestMapping("/age/min")
fun getCountryWithMinMedianAge(): Country? {
    if (CountriesList.countryList.size == 0) {
        return null
    }

    var countryWithMinMedianAge = CountriesList.countryList[0]
    var i = 1
    while (i < CountriesList.countryList.size) {
        val country = CountriesList.countryList[i]
        if (country.medianAge < countryWithMinMedianAge.medianAge) {
            countryWithMinMedianAge = country
        }

        ++i
    }

    return countryWithMinMedianAge
}

// return the country the the greatest median age
@RequestMapping("/age/max")
fun getCountryWithMaxMedianAge(): Country? {
    if (CountriesList.countryList.size == 0) {
        return null
    }

    var countryWithMaxMedianAge = CountriesList.countryList[0]
    var i = 1
    while (i < CountriesList.countryList.size) {
        val country = CountriesList.countryList[i]
        if (country.medianAge > countryWithMaxMedianAge.medianAge) {
            countryWithMaxMedianAge = country
        }

        ++i
    }

    return countryWithMaxMedianAge;
}