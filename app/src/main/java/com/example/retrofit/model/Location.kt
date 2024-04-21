package com.example.retrofit.model

data class Location(
    val city: String,
    val country: String,
    val state: String,
    val street: Street,
    val timezone: Timezone
)