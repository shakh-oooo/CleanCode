package com.example.cleancc.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.cleancc.R
import com.example.cleancc.mvvm.MainViewModel
import com.example.cleancc.mvvm.MvvmFactory

class MainActivity : AppCompatActivity() {

    private lateinit var vm:MainViewModel

/*
    private val repository by lazy  (LazyThreadSafetyMode.NONE) {Repository(storageInterface = SharedPreferens(context = applicationContext)) }
*/
/*
    private val useCaseToSave by lazy (LazyThreadSafetyMode.NONE){SaveUseCase(repository)}
*/
/*
    private val useCaseToGet by lazy (LazyThreadSafetyMode.NONE){ GetUseCase(repository) }
*/


    private val textView get()=findViewById<TextView>(R.id.textView)
    private val edtName get()=findViewById<EditText>(R.id.edt_txt1)
    private val edtLast get()=findViewById<EditText>(R.id.edt_txt2)
    private val btnSave get()=findViewById<Button>(R.id.btn_save)
    private val btnGet get()=findViewById<Button>(R.id.btn_get)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        save()
        gett()



        vm=ViewModelProvider(this,MvvmFactory(this)).get(MainViewModel::class.java)


        vm.ret.observe(this) {
            textView.text = it
        }

    }



    @SuppressLint("SuspiciousIndentation")
    private fun save(){
        btnSave.setOnClickListener {
        val a = edtName.text.toString()
        val b = edtLast.text.toString()
            vm.saveee(a=a, b=b)

        /*val par = ModelSaveName(name = a, last = b)
        val res = useCaseToSave.savesavename(saveparam = par)*/

        }
    }
    @SuppressLint("SetTextI18n")
    private fun gett(){
        btnGet.setOnClickListener {

            /*val a :ModelGetName=useCaseToGet.getgetnamefun()*/
            vm.getttt()
        }
    }

}


