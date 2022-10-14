package com.example.data.storage.sharedPrefs

import android.content.Context
import com.example.data.storage.Const
import com.example.data.storage.StorageInterface
import com.example.data.storage.models.ModelStorageGetName
import com.example.data.storage.models.ModelStorageSaveName


class SharedPreferens(context: Context):StorageInterface{



    private val shared =context.getSharedPreferences(Const.sharedPref,Context.MODE_PRIVATE)


    override fun storageSave(paramStorage: ModelStorageSaveName) {
        shared.edit().putString(Const.firstName,paramStorage.sname).apply()
        shared.edit().putString(Const.lastName,paramStorage.slast).apply()
    }

    override fun storageGet(): ModelStorageGetName {

        val firstname =shared.getString(Const.firstName,Const.defaultName)?:Const.defaultName
        val lastname =shared.getString(Const.lastName,Const.defaultName)?:Const.defaultName

        return ModelStorageGetName(firstname,lastname)
    }
}