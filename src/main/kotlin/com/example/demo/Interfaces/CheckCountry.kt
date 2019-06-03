package com.example.demo.Interfaces

import com.example.demo.Models.Country


interface CheckCountry {
    fun check(c: Country): Boolean
}