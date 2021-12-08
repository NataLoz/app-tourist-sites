package com.jmarti.proyectosemtres.data

class PointinterestRepository {

    suspend fun getPointinterests() = ApiFactory.retrofit.getPointinterests()

}