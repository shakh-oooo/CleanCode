package com.example.cleancc.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleancc.R
import com.example.cleancc.mvvm.MainViewModel
import com.example.cleancc.mvvm.MvvmFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private val textView get() = findViewById<TextView>(R.id.textView)
    private val edtName get() = findViewById<EditText>(R.id.edt_txt1)
    private val edtLast get() = findViewById<EditText>(R.id.edt_txt2)
    private val btnSave get() = findViewById<Button>(R.id.btn_save)
    private val btnGet get() = findViewById<Button>(R.id.btn_get)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveNameLastName()
        getNameLastName()

        viewModel = ViewModelProvider(this, MvvmFactory(this))[MainViewModel::class.java]

        viewModel.liveData.observe(this) {
            textView.text = it
        }

    }


    @SuppressLint("SuspiciousIndentation")
    private fun saveNameLastName() {
        btnSave.setOnClickListener {
            val name = edtName.text.toString()
            val lastName = edtLast.text.toString()
            viewModel.savaMV(name = name, lastName = lastName)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getNameLastName() {
        btnGet.setOnClickListener {
            viewModel.getMV()
        }
    }

}


