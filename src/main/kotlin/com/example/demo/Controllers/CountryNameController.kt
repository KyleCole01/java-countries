package com.example.demo.Controllers

import com.example.demo.Models.Country
import com.example.demo.Repo.CountriesList
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CountryNameController {

    // return the names of all the countries alphabetically
    @RequestMapping(value = ["/names/all"],
            produces = ["application/json"])
    fun getCountries_name(): MutableList<String> {
        val countryNames = mutableListOf<String>()
        for (country in CountriesList.countryList) {
            countryNames.add(country.name)
        }
        return countryNames
    }

    // return the countries alphabetically that begin with the given letter
    @RequestMapping(value = ["/names/begin="], produces = ["application/json"])
    fun getCountriesBeginWith(@RequestParam(value = "letter") letter: String): MutableList<Country> {
        val countries = mutableListOf<Country>()
        if (letter.length != 1) {
            return countries
        }

        for (country in CountriesList.countryList) {
            // ignore case
            if (Character.toLowerCase(country.name[0])
                    == Character.toLowerCase(letter[0])) {
                countries.add(country)
            }
        }

        countries.sortBy { it.name }

        return countries
    }

    // return the countries alphabetically that have a name equal to or longer than the given length
    @RequestMapping("/names/size")
    fun getCountriesSizeLetters(@RequestParam("letters") letters: Int): MutableList<Country> {
        if (letters < 1) {
            return CountriesList.countryList
        }

        val countries = ArrayList<Country>()
        for (country in CountriesList.countryList) {
            if (country.name.length >= letters) {
                countries.add(country)
            }
        }

        countries.sortBy { it.name }

        return countries
    }


}