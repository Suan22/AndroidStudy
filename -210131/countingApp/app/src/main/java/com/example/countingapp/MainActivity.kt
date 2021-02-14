package com.example.countingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "테이블 레이아웃 계산기"

        btn0.setOnClickListener {
            if (Edit1.isFocused) {
                val num = Edit1.text.toString()
                if (!num.equals("0")) {
                    Edit1.setText(num + "0")
                }
            } else if (Edit2.isFocused) {
                val num = Edit2.text.toString()
                if (!num.equals("0")) {
                    Edit2.setText(num + "0")
                }
            }
        }
        btn1.setOnClickListener {
            if (Edit1.isFocused) {
                val num = Edit1.text.toString()
                if (!num.equals("0")) {
                    Edit1.setText(num + "1")
                } else{
                    Edit1.setText("1")
                }
            } else if (Edit2.isFocused) {
                val num = Edit2.text.toString()
                if (!num.equals("0")) {
                    Edit2.setText(num + "1")
                } else {
                    Edit2.setText("1")
                }
            }
        }

        btn2.setOnClickListener {
            if (Edit1.isFocused) {
                val num = Edit1.text.toString()
                if (!num.equals("0")) {
                    Edit1.setText(num + "2")
                } else {
                    Edit1.setText("2")
                }
            } else if (Edit2.isFocused) {
                val num = Edit2.text.toString()
                if (!num.equals("0")) {
                    Edit2.setText(num + "2")
                } else {
                    Edit2.setText("2")
                }
            }
        }

        btn3.setOnClickListener {
            if (Edit1.isFocused) {
                val num = Edit1.text.toString()
                if (!num.equals("0")) {
                    Edit1.setText(num + "3")
                } else {
                    Edit1.setText("3")
                }
            } else if (Edit2.isFocused) {
                val num = Edit2.text.toString()
                if (!num.equals("0")) {
                    Edit2.setText(num + "3")
                } else {
                    Edit2.setText("3")
                }
            }
        }

        btn4.setOnClickListener {
            if (Edit1.isFocused) {
                val num = Edit1.text.toString()
                if (!num.equals("0")) {
                    Edit1.setText(num + "4")
                } else {
                    Edit1.setText("4")
                }
            } else if (Edit2.isFocused) {
                val num = Edit2.text.toString()
                if (!num.equals("0")) {
                    Edit2.setText(num + "4")
                } else {
                    Edit2.setText("4")
                }
            }
        }

        btn5.setOnClickListener {
            if (Edit1.isFocused) {
                val num = Edit1.text.toString()
                if (!num.equals("0")) {
                    Edit1.setText(num + "5")
                } else {
                    Edit1.setText("5")
                }
            } else if (Edit2.isFocused) {
                val num = Edit2.text.toString()
                if (!num.equals("0")) {
                    Edit2.setText(num + "5")
                } else {
                    Edit2.setText("5")
                }
            }
        }

        btn6.setOnClickListener {
            if (Edit1.isFocused) {
                val num = Edit1.text.toString()
                if (!num.equals("0")) {
                    Edit1.setText(num + "6")
                } else {
                    Edit1.setText("6")
                }
            } else if (Edit2.isFocused) {
                val num = Edit2.text.toString()
                if (!num.equals("0")) {
                    Edit2.setText(num + "6")
                } else {
                    Edit2.setText("6")
                }
            }
        }

        btn7.setOnClickListener {
            if (Edit1.isFocused) {
                val num = Edit1.text.toString()
                if (!num.equals("0")) {
                    Edit1.setText(num + "7")
                } else {
                    Edit1.setText("7")
                }
            } else if (Edit2.isFocused) {
                val num = Edit2.text.toString()
                if (!num.equals("0")) {
                    Edit2.setText(num + "7")
                } else {
                    Edit2.setText("7")
                }
            }
        }

        btn8.setOnClickListener {
            if (Edit1.isFocused) {
                val num = Edit1.text.toString()
                if (!num.equals("0")) {
                    Edit1.setText(num + "8")
                } else {
                    Edit1.setText("8")
                }
            } else if (Edit2.isFocused) {
                val num = Edit2.text.toString()
                if (!num.equals("0")) {
                    Edit2.setText(num + "8")
                } else {
                    Edit2.setText("8")
                }
            }
        }

        btn9.setOnClickListener {
            if (Edit1.isFocused) {
                val num = Edit1.text.toString()
                if (!num.equals("0")) {
                    Edit1.setText(num + "9")
                } else {
                    Edit1.setText("9")
                }
            } else if (Edit2.isFocused) {
                val num = Edit2.text.toString()
                if (!num.equals("0")) {
                    Edit2.setText(num + "9")
                } else {
                    Edit2.setText("9")
                }
            }
        }

        btnAdd.setOnClickListener {
            val num1 = Edit1.text.toString()
            val num2 = Edit2.text.toString()
            if (num1.trim().equals("") || num2.trim().equals("")) {
                textView.text = "입력창이 비었습니다."
            } else {
                val result = num1.toDouble() + num2.toDouble()
                textView.text = "계산 결과 : " + result.toString()
            }
        }

        btnSub.setOnClickListener {
            val num1 = Edit1.text.toString()
            val num2 = Edit2.text.toString()
            if (num1.trim().equals("") || num2.trim().equals("")) {
                textView.text = "입력창이 비었습니다."
            } else {
                val result = num1.toDouble() - num2.toDouble()
                textView.text = "계산 결과 : " + result.toString()
            }
        }

        btnMul.setOnClickListener {
            val num1 = Edit1.text.toString()
            val num2 = Edit2.text.toString()
            if (num1.trim().equals("") || num2.trim().equals("")) {
                textView.text = "입력창이 비었습니다."
            } else {
                val result = num1.toDouble()*num2.toDouble()
                textView.text = "계산 결과 : " + result.toString()
            }
        }

        btnDiv.setOnClickListener {
            val num1 = Edit1.text.toString()
            val num2 = Edit2.text.toString()
            if (num1.trim().equals("") || num2.trim().equals("")) {
                textView.text = "입력창이 비었습니다."
            } else if(num1.equals("0") || num2.equals("0")) {
                textView.text = "0으로 나눌 수 없습니다."
            }else{
                val result = num1.toDouble()/num2.toDouble()
                textView.text = "계산 결과 : " + result.toString()
            }
        }

    }
}