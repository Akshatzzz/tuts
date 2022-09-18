package com.kcdeepak.faceapp

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MyViewModel(context: Context) : ViewModel(){
    private val dao = UserFaceDatabase.getDatabase(context).userFaceDao()
    private val repository = MyRepository(dao)

    fun loadAllUsers():List<UserFace> = runBlocking {
        repository.loadAllUsers().await()
    }
    fun insertFaceUser(userFace: UserFace){
        GlobalScope.launch(Dispatchers.IO){
            repository.addFaceUser(userFace)
        }
    }
}