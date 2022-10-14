package com.example.data.storage

import com.example.data.storage.models.ModelStorageGetName
import com.example.data.storage.models.ModelStorageSaveName


interface StorageInterface {
    fun storageSave(paramStorage: ModelStorageSaveName)
    fun storageGet():ModelStorageGetName
}