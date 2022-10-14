package com.example.data.repository

import com.example.data.storage.StorageInterface
import com.example.data.storage.models.ModelStorageGetName
import com.example.data.storage.models.ModelStorageSaveName
import com.example.domain.RepositoryInterface
import com.example.domain.models.ModelGetName
import com.example.domain.models.ModelSaveName

class Repository(private val storageInterface: StorageInterface) : RepositoryInterface {
    override fun saveName(saveNameParamInterface: ModelSaveName) {
        val user = mapToStorage(saveNameParamInterface)
        storageInterface.storageSave(user)

    }

    private fun mapToStorage(param: ModelSaveName): ModelStorageSaveName {
        return ModelStorageSaveName(sname = param.name, slast = param.last)
    }

    override fun getName(): ModelGetName {
        val user = storageInterface.storageGet()
        return mapToDomain(user)
    }

    private fun mapToDomain(modelgetname: ModelStorageGetName): ModelGetName {
        return ModelGetName(name = modelgetname.gname, last = modelgetname.glast)
    }
}