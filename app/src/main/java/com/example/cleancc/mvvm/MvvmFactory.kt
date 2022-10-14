package com.example.cleancc.mvvm

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.repository.Repository
import com.example.data.storage.sharedPrefs.SharedPreferens
import com.example.domain.usecase.GetUseCase
import com.example.domain.usecase.SaveUseCase

class MvvmFactory(context: Context):ViewModelProvider.Factory {

    private val repository by lazy  (LazyThreadSafetyMode.NONE) { Repository(storageInterface = SharedPreferens(context = context)) }
    private val useCaseToSave by lazy (LazyThreadSafetyMode.NONE){ SaveUseCase(repository) }
    private val useCaseToGet by lazy (LazyThreadSafetyMode.NONE){ GetUseCase(repository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(useCasesave = useCaseToSave, useCaseget = useCaseToGet) as T
    }


}