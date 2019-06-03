package com.example.demo.interfaces

import com.example.demo.models.Country


interface CheckCountry {
    fun check(c: Country): Boolean
}