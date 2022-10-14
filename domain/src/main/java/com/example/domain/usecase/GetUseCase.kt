package com.example.domain.usecase

import com.example.domain.RepositoryInterface
import com.example.domain.models.ModelGetName

class GetUseCase(private val getget : RepositoryInterface) {
    fun getgetnamefun():ModelGetName{
        return getget.getName()
    }
}