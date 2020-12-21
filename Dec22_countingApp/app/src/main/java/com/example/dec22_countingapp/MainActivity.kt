package com.example.dec22_countingapp


import android.os.Bundle
import android.util.Log.e

import android.view.View

import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

//TextView 위젯을 사용할 변수 textView
    
    lateinit var textView: TextView

//덧셈 버튼 클릭 유무를 판단하기 위한 변수

    var ADD = 0

//뺄셈 버튼 클릭 유무를 판단하기 위한 변수

    var SUB = 0

//곱셈 버튼 클릭 유무를 판단하기 위한 변수

    var MUL = 0

    //나눗셈 버튼 클릭 유무를 판단하기 위한 변수   
var DIV = 0

//계산기를 처음 실행한 상태 혹은 결과값 도출 후라면 1을

//계산기 첫 실행 후 숫자 키패드를 누른 상태로 결과값 도출 전 혹은

//결과값 도출 후 숫자 키패드를 누른 상태라면 0을 저장하게 만들 변수

var REMAIN = 1

// x + y , x -y , x * y , x / y 중

// x에 해당하는 값을 저장하기 위한 실수형 변수

var save1 = 0.0

// x + y , x -y , x * y , x / y 중

// x에 해당하는 값을 저장하기 위한 문자열 변수

// textView에 저장된 값을 문자열 형태로 저장한 후 실수형태로 변환하여

// save1에 저장하기 위한 용도로 사용

var stringNumber1 = ""

// x + y , x -y , x * y , x / y 중

// y에 해당하는 값을 저장하기 위한 실수형 변수

var save2 = 0.0

// x + y , x -y , x * y , x / y 중

// y에 해당하는 값을 저장하기 위한 문자열 변수

// textView에 저장된 값을 문자열 형태로 저장한 후 실수형태로 변환하여

// save2에 저장하기 위한 용도로 사용

var stringNumber2 = ""

override fun onCreate(savedInstanceState: Bundle?) {

    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_main)

//textView 변수에서 이용할 TextView의 아이디 값

    textView=findViewById(R.id.textView)

    val onClickListener =

            View.OnClickListener { view ->

//뷰에서 클린한 버튼의 아이디 값이 무엇인가에 따른 이벤트 처리

                when (view.id) {

/* + */

                    R.id.button -> {

//결과값 함수를 실행

                        result()

//더하기 버튼을 누른 상태임을 저장

                        ADD = 1

//화면에 기존 값이 남아있는 상태임을 저장

                        REMAIN = 1

                    }

/* - */

                    R.id.button5 -> {

                        result()

//빼기 버튼을 누른 상태임을 저장

                        SUB = 1

                        REMAIN = 1

                    }

/* * */

                    R.id.button9 -> {

                        result()

//곱하기 버튼을 누른 상태임을 저장

                        MUL = 1

                        REMAIN = 1

                    }

/* / */

                    R.id.button13 -> {

                        result()

//나누기 버튼을 누른 상태임을 저장

                        DIV = 1

                        REMAIN = 1

                    }

/* = */

                    R.id.button18 -> {

                        result()

                        REMAIN = 1

                    }

/* +/- */

                    R.id.button4 -> {

//REMAIN에 저장된 값이 1이고, save1에 저장된 값이 0.0이 아니라면

                        if(REMAIN == 1 && save1!=0.0) {

//save1 = -save1

                            save1 = -save1

//실수형 save1에서 정수형 save1을 뺀 값이 0.0이라면

                            if(save1-save1.toInt()==0.0) {

//textView와 연결된 TextView에 save1에 저장된 값을 정수형 형태의 문자열로 표시

                                textView.text = ""+save1.toInt()

//실수형 save1에서 정수형 save1을 뺀 값이 0.0이 아니라면

                            } else {

//textView와 연결된 TextView에 save1에 저장된 값을 실수형 형태의 문자열로 표시

                                textView.text = save1.toString()

                            }

                        } else {

//stringNumber2에 textView에 저장된 문자열을 저장

                            stringNumber2 = "" + textView.text

//save2에 stringNumber2에 저장된 문자열을 실수 형태로 저장

                            save2 = stringNumber2.toDouble()

//save2에 저장된 값이 0.0이 아니라면

                            if(save2!=0.0) {

//save2 = -save2

                                save2 = -save2

//생략

                                if(save2-save2.toInt()==0.0) {

                                    textView.text = ""+save2.toInt()

                                } else {

                                    textView.text = save2.toString()

                                }

                            }

//stringNumber2를 공란으로 초기화

                            stringNumber2 = ""

//save2에 저장된 값을 0.0으로 초기화

                            save2 = 0.0

                        }

                    }

/* % */

                    R.id.button3 -> {

//RAMAIN이 1이라면

                        if(REMAIN == 1) {

//save1에 저장된 값을 100으로 나눈 뒤 다시 save1에 저장

                            save1 /= 100.0

//생략

                            if(save1-save1.toInt()==0.0) {

                                textView.text = ""+save1.toInt()

                            } else {

                                textView.text = save1.toString()

                            }

//REMAIN이 0이라면

                        } else {

//생략

                            stringNumber2 = "" + textView.text

                            save2 = stringNumber2.toDouble()

                            save2 /= 100.0

                            if(save2-save2.toInt()==0.0) {

                                textView.text = ""+save2.toInt()

                            } else {

                                textView.text = save2.toString()

                            }

                            stringNumber2 = ""

                            save2 = 0.0

                        }

                    }

//초기화 버튼

                    R.id.button2 -> {

//계산기를 처음 실행 혹은 결과값 도출 후 숫자 키패드를 누르기 전이라면

                        if(REMAIN == 1) {

//stringNumber1을 공란으로 초기화

                            stringNumber1=""

//save1을 0.0으로 초기화

                            save1=0.0

//textView와 연결된 TextView에 0을 표기

                            textView.text="0"

//다른 값을 입력하여 남은 값이 사라진 상태라면

                        } else {

//textView와 연결된 TextView에 0을 표기

                            textView.text="0"

                        }

                    }

//아이디 값이 button20인 버튼을 클릭했다면

                    R.id.button20 -> {

//textView에 저장된 text값이 0 또는 REMAIN에 저장된 값이 1이라면 공란처리

                        if(textView.text=="0"||REMAIN == 1) textView.text=""

//textView에 저장된 text 문자열 값 끝에 0을 추가

                        textView.text = textView.text.toString() + 0

                        REMAIN = 0

                    }

//생략

                    R.id.button16 -> {

                        if(textView.text=="0"||REMAIN == 1) textView.text=""

                        textView.text = textView.text.toString() + 1

                        REMAIN = 0

                    }

                    R.id.button15 -> {

                        if(textView.text=="0"||REMAIN == 1) textView.text=""

                        textView.text = textView.text.toString() + 2

                        REMAIN = 0

                    }

                    R.id.button14 -> {

                        if(textView.text=="0"||REMAIN == 1) textView.text=""

                        textView.text = textView.text.toString() + 3

                        REMAIN = 0

                    }

                    R.id.button12 -> {

                        if(textView.text=="0"||REMAIN == 1) textView.text=""

                        textView.text = textView.text.toString() + 4

                        REMAIN = 0

                    }

                    R.id.button11 -> {

                        if(textView.text=="0"||REMAIN == 1) textView.text=""

                        textView.text = textView.text.toString() + 5

                        REMAIN = 0

                    }

                    R.id.button10 -> {

                        if(textView.text=="0"||REMAIN == 1) textView.text=""

                        textView.text = textView.text.toString() + 6

                        REMAIN = 0

                    }

                    R.id.button8 -> {

                        if(textView.text=="0"||REMAIN == 1) textView.text=""

                        textView.text = textView.text.toString() + 7

                        REMAIN = 0

                    }

                    R.id.button7 -> {

                        if(textView.text=="0"||REMAIN == 1) textView.text=""

                        textView.text = textView.text.toString() + 8

                        REMAIN = 0

                    }

                    R.id.button6 -> {

                        if(textView.text=="0"||REMAIN == 1) textView.text=""

                        textView.text = textView.text.toString() + 9

                        REMAIN = 0

                    }

                    R.id.button19 -> {

                        if(textView.text=="0"||REMAIN == 1) textView.text="0"

//textView에 저장된 text값에 .이 포함되지 않았다면 text 문자열 끝에 .을 추가

                        if(!textView.text.contains(".")) textView.text = textView.text.toString() + "."

                        REMAIN = 0

                    }

                }

            }


    button15.setOnClickListener(onClickListener)

/* 3 */

    button14.setOnClickListener(onClickListener)

/* 4 */

    button12.setOnClickListener(onClickListener)

/* 5 */

    button11.setOnClickListener(onClickListener)

/* 6 */

    button10.setOnClickListener(onClickListener)

/* 7 */

    button8.setOnClickListener(onClickListener)

/* 8 */

    button7.setOnClickListener(onClickListener)

/* 9 */

    button6.setOnClickListener(onClickListener)

/* . */

    button19.setOnClickListener(onClickListener)

/* + */

    button.setOnClickListener(onClickListener)

/* - */

    button5.setOnClickListener(onClickListener)

/* * */

    button9.setOnClickListener(onClickListener)

/* / */

    button13.setOnClickListener(onClickListener)

/* = */

    button18.setOnClickListener(onClickListener)

/* +/- */

    button4.setOnClickListener(onClickListener)

/* % */

    button3.setOnClickListener(onClickListener)

/* C */

    button2.setOnClickListener(onClickListener)

}

//결과값

private fun result() {

//사칙연산 버튼을 누르지 않은 상태 혹은

//사칙연산 버튼을 눌렀음을 판단하기 위한 변수에 아직 1이 저장되기 전이라면

    if(ADD==0&&SUB==0&&MUL==0&&DIV==0) {

//stringNumber1에 textView에 저장된 문자열을 저장

        stringNumber1 = ""+textView.text

//save1에 stringNumber1에 저장된 문자열을 실수형태로 변환하여 저장

        save1 = stringNumber1.toDouble()

    }

//stringNumber1에 저장된 값이 공란이라면

    if(stringNumber1 == "") {

//생략

        stringNumber1 = ""+textView.text

        save1 = stringNumber1.toDouble()

//stringNumber1에 저장된 값이 공란이 아니라면

    } else {

//REMAIN에 저장된 값이 0이라면

        if(REMAIN == 0) {

//생략

            stringNumber2 = "" + textView.text

            save2 = stringNumber2.toDouble()

//덧셈 버튼을 눌렀음을 판단하는 변수에 1이 저장된 상태라면

            if(ADD == 1) {

//save1 = save1 + save2

                save1 += save2

//덧셈 버튼을 눌렀다는 사실에 대해 초기화

                ADD = 0

            }

//뺄셈 버튼을 눌렀음을 판단하는 변수에 1이 저장된 상태라면

            if(SUB == 1) {

//save1 = save1 - save2

                save1 -= save2

//뺄셈 버튼을 눌렀다는 사실에 대해 초기화

                SUB = 0

            }

//곱셈 버튼을 눌렀음을 판단하는 변수에 1이 저장된 상태라면

            if(MUL == 1) {

//save1 = save1 * save2

                save1 *= save2

//곱셈 버튼을 눌렀다는 사실에 대해 초기화

                MUL = 0

            }

//나눗셈 버튼을 눌렀음을 판단하는 변수에 1이 저장된 상태라면

            if(DIV == 1) {

//save1 = save1 / save2

                save1 /= save2

//나눗셈 버튼을 눌렀다는 사실에 대해 초기화

                DIV = 0

            }

//생략

            stringNumber2=""

            save2=0.0

// REMAIN에 저장된 값이 1이라면

        } else {

//사칙 연산 버튼을 눌렀다는 사실에 대해 초기화

//이는 마지막에 누른 사칙 연산 버튼에 대해서만

//계산할 수 있도록 하기 위함

            ADD=0

            SUB=0

            MUL=0

            DIV=0

        }

    }

//생략

    if(save1-save1.toInt()==0.0) {

        textView.text = ""+save1.toInt()

    } else {

        textView.text = save1.toString()

    }

}

}
