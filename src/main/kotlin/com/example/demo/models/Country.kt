package com.example.demo.models

class Country(var name: String, var population: Int, var landMass: Int, var medianAge: Int){
    override fun toString(): String {
        return "Country(name= '$name', population = $population, landmass = $landMass, Median Age = $medianAge"
           }
}