package com.jmarti.proyectosemtres.ui.main.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.jmarti.proyectosemtres.data.PointinterestRepository
import com.jmarti.proyectosemtres.model.Pointinterest
import com.jmarti.proyectosemtres.model.PointinterestItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var pointinterestsload : MutableLiveData<ArrayList<PointinterestItem>> = MutableLiveData()
    val onPointinterestsLoaded: LiveData<ArrayList<PointinterestItem>> = pointinterestsload

    private val repository = PointinterestRepository()

    fun getPointinterestsFromServer(){
        GlobalScope.launch (Dispatchers.IO) {
            pointinterestsload.postValue(repository.getPointinterests())
        }

    }

    fun loadMockPointinterestsFromJson(pointinterestsString: InputStream?){
        val pointinterestsString = pointinterestsString?.bufferedReader().use{it!!.readText()}
        val gson = Gson()
        pointinterestsload.value = gson.fromJson(pointinterestsString, Pointinterest::class.java)
    }

}