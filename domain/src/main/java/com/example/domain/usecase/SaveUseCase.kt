package com.example.domain.usecase

import com.example.domain.RepositoryInterface
import com.example.domain.models.ModelSaveName

class SaveUseCase(private val save: RepositoryInterface) {
    fun saveNameUseCase(saveParam: ModelSaveName) {
        save.saveName(saveNameParamInterface = saveParam)
    }
}