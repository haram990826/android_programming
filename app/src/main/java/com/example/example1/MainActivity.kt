package com.example.example1

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit internal var edit1 : EditText
    lateinit internal var edit2 : EditText
    lateinit internal var btnAdd : Button
    lateinit internal var btnSub : Button
    lateinit internal var btnMul : Button
    lateinit internal var btnDiv : Button
    lateinit internal var textResult : TextView
    lateinit internal var num1 : String
    lateinit internal var num2 : String
    var result : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "사칙 연산 계산기"

        edit1 = findViewById(R.id.edit1)
        edit2 = findViewById(R.id.edit2)
        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMul = findViewById(R.id.btnMul)
        btnDiv = findViewById(R.id.btnDiv)

        textResult = findViewById(R.id.textResult)
        var numButtons  = ArrayList<Button>(10)
        var numBtnIDs = arrayOf(R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9)


        for (i in 0..numButtons.size-1 step 1){
            numButtons[i].setOnClickListener {
                // 포커스가 되어 있는 에디트텍스트에 숫자 추가
                if (edit1.isFocused == true) {
                    num1 = edit1.text.toString() + numButtons[i].getText().toString()
                    edit1.setText(num1)
                } else if (edit2.isFocused == true) {
                    num2 = edit2.text.toString() + numButtons[i].getText().toString()
                    edit2.setText(num2)
                } else {
                    Toast.makeText(applicationContext,
                        "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show()
                }
            }
        }


        btnAdd.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(p0: View?, motionEvent: MotionEvent?): Boolean {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) + Integer.parseInt(num2)
                textResult.text = "계산결과:" + result.toString()
                false
                return true
            }
        })

        btnSub.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(p0: View?, motionEvent: MotionEvent?): Boolean {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) - Integer.parseInt(num2)
                textResult.text = "계산결과:" + result.toString()
                false
                return true
            }
        })

        btnMul.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(p0: View?, motionEvent: MotionEvent?): Boolean {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) * Integer.parseInt(num2)
                textResult.text = "계산결과:" + result.toString()
                false
                return true
            }
        })

        btnDiv.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(p0: View?, motionEvent: MotionEvent?): Boolean {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) / Integer.parseInt(num2)
                textResult.text = "계산결과:" + result.toString()
                false
                return true
            }
        })

    }
}