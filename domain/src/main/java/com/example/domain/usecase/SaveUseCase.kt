package com.example.domain.usecase

import com.example.domain.RepositoryInterface
import com.example.domain.models.ModelSaveName

class SaveUseCase(private val savesave:RepositoryInterface) {
    fun savesavename(saveparam:ModelSaveName) {

        savesave.saveName(saveNameParamInterface = saveparam)
    }
}