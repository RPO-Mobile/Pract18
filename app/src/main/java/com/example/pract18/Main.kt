package com.example.pract18

import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import com.example.pract18.databinding.MainActBinding
import com.example.pract18.databinding.TextViewLayoutBinding
import com.example.pract18.databinding.UserViewLayoutBinding

class Main : AppCompatActivity() {
    private lateinit var mainAct : MainActBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainAct = MainActBinding.inflate(layoutInflater)
        setContentView(mainAct.root)

        mainAct.btn1.setOnClickListener{
            btnClicked(it)
        }
        mainAct.btn2.setOnClickListener{
            btnClicked(it)
        }

    }

    fun showTextView(text: String){
        val textViewLayout = TextViewLayoutBinding.inflate(layoutInflater)
        textViewLayout.root.text = text
        mainAct.containerLayout.addView(textViewLayout.root)
    }

    fun showUserView(age: Int, name:String){
        val userViewLayout = UserViewLayoutBinding.inflate(layoutInflater)
        userViewLayout.age.text = age.toString()
        userViewLayout.name.text = name.toString()
        mainAct.containerLayout.addView(userViewLayout.root)
    }

    fun btnClicked(sender: View){
        if (mainAct.et1.text.toString() == ""){
            val toast = Toast.makeText(this, "Заполните первое поле", Toast.LENGTH_SHORT)
            toast.show()
            return
        }

        when (sender){
            mainAct.btn2 -> {
                if (mainAct.et1.text.isDigitsOnly() && mainAct.et1.text.toString() != "") {
                    showUserView(mainAct.et1.text.toString().toInt(), mainAct.et2.text.toString())
                } else{
                    val toast = Toast.makeText(this, "Введите возраст в первое поле", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
            mainAct.btn1 -> {
                showTextView(mainAct.et1.text.toString())
            }
        }

    }
}