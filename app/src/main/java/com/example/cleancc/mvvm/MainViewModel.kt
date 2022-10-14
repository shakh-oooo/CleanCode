package com.example.cleancc.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.ModelGetName
import com.example.domain.models.ModelSaveName
import com.example.domain.usecase.GetUseCase
import com.example.domain.usecase.SaveUseCase

class MainViewModel(private val useCaseget: GetUseCase,private val useCasesave: SaveUseCase ):ViewModel() {

    private val retern = MutableLiveData<String>()
    val ret : LiveData<String> = retern


    fun saveee(a:String,b:String){
        val par = ModelSaveName(name = a, last = b)
        val bar = useCasesave.savesavename(saveparam = par)
        retern.value = bar.toString()

    }
    fun getttt(){
        val a : ModelGetName =useCaseget.getgetnamefun()
        val c = "${a.name} ${a.last}"
        retern.value = c
    }
}