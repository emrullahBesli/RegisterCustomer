package com.besli.register.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern

data class RegisterCustomerRequest(
        @field:NotNull(message = "İsim boş olamaz")
        val name: String,
        @field:NotNull(message = "SoyAd boş olamaz")
        val surName: String,
        @field:Pattern(regexp = "0[0-9]{10}", message = "Geçerli bir Türkiye telefon numarası giriniz.")
        val phoneNumber: String,
        @field:Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Geçerli bir e-posta adresi giriniz.")
        val email:String,
        val explanation: String,
)
