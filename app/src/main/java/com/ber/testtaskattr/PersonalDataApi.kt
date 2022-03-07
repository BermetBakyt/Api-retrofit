package com.ber.testtaskattr

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface PersonalDataApi {
    @GET("/userGet")
    fun getAll(): Single<Response>
}