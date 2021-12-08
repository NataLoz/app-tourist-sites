package com.jmarti.proyectosemtres.data

import com.jmarti.proyectosemtres.model.Pointinterest
import retrofit2.http.GET

interface ApiService {

    @GET("NataLoz/app-tourist-sites/pointinterests")
    suspend fun getPointinterests(): Pointinterest

}