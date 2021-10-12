package com.project.livedata_viewmodel_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var myNumberViewModel: MyNumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)

        myNumberViewModel.currentValue.observe(this, Observer {
            number_textview.text = it.toString()
        })

        // connect listener
        plus_btn.setOnClickListener(this)
        minus_btn.setOnClickListener(this)
    }

    // 클릭
    override fun onClick(view: View?) {
        val userInput = userinput_edittext.text.toString().toInt()

        when(view) {
            plus_btn ->
                myNumberViewModel.updateValue(actionType = ActionType.PLUS, userInput)
            minus_btn ->
                myNumberViewModel.updateValue(actionType = ActionType.MINUS, userInput)
        }
    }
}