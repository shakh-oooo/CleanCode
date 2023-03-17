package com.example.data.storage.sharedPrefs

import android.content.Context
import com.example.data.storage.Const
import com.example.data.storage.StorageInterface
import com.example.data.storage.models.ModelStorageGetName
import com.example.data.storage.models.ModelStorageSaveName


class SharedPreferences(context: Context):StorageInterface{

    private val shared =context.getSharedPreferences(Const.sharedPref,Context.MODE_PRIVATE)


    override fun storageSave(modelStorageSaveName: ModelStorageSaveName) {
        shared.edit().putString(Const.firstName,modelStorageSaveName.storageSaveName).apply()
        shared.edit().putString(Const.lastName,modelStorageSaveName.saveLastName).apply()
    }

    override fun storageGet(): ModelStorageGetName {

        val firstname =shared.getString(Const.firstName,Const.defaultName)?:Const.defaultName
        val lastname =shared.getString(Const.lastName,Const.defaultName)?:Const.defaultName

        return ModelStorageGetName(firstname,lastname)
    }
}