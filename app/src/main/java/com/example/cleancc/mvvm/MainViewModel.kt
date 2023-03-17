package com.example.cleancc.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.ModelGetName
import com.example.domain.models.ModelSaveName
import com.example.domain.usecase.GetUseCase
import com.example.domain.usecase.SaveUseCase

class MainViewModel(
    private val useCaseGet: GetUseCase,
    private val useCaseSave: SaveUseCase) : ViewModel() {

    private val mutableLV = MutableLiveData<String>()
    val liveData: LiveData<String>
    get() = mutableLV


    fun savaMV(name: String, lastName: String) {
        val param = ModelSaveName(saveName = name, saveLastName = lastName)
        val bar = useCaseSave.saveNameUseCase(saveParam = param)
        mutableLV.value = bar.toString()

    }

    fun getMV() {
        val modelName: ModelGetName = useCaseGet.getNameUseCase()
        val getAll = "${modelName.getName} ${modelName.getLastName}"
        mutableLV.value = getAll
    }
}