package com.ber.testtaskattr

data class Response (val user: User)
data class User(
    val first_name: String,
    val second_name: String,
    val education: Int,
    val company: Company,
    val photo: String
)

data class Company(
    val name: String,
    val position: String
)