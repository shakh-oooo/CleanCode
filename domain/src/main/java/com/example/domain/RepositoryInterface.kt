package com.example.domain

import com.example.domain.models.ModelGetName
import com.example.domain.models.ModelSaveName

interface RepositoryInterface {
    fun saveName(saveNameParamInterface: ModelSaveName)
    fun getName(): ModelGetName
}