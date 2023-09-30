package com.besli.register.dto

import java.time.LocalDate

data class CustomerDto(

        val name: String,
        val surName: String,
        val phoneNumber: String,
        val email:String,
        val explanation: String,
        val date: LocalDate
)
