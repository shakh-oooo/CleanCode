package com.example.domain.usecase

import com.example.domain.RepositoryInterface
import com.example.domain.models.ModelGetName

class GetUseCase(private val get: RepositoryInterface) {
    fun getNameUseCase(): ModelGetName {
        return get.getName()
    }
}