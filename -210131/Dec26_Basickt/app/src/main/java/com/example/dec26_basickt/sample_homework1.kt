package com.example.dec26_basickt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class sample_homework1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_homework1)

        val operator:Operator= Operator()
        Log.d("더하기","" + operator.plus(4,5))
        Log.d("빼기","" + operator.minus(4,5))
        Log.d("곱하기","" + operator.multi(4,5))
        Log.d("나누기","" + operator.divi(4,5))

        val operator2:Operator2= Operator2()
        Log.d("더하기","" + operator2.plus(1,2,3,4,5))
        Log.d("빼기","" + operator2.minus(10,2,3,4))
        Log.d("곱하기","" + operator2.multi(1,2,3,4))
        Log.d("나누기","" + operator2.divide(10,2,3))


        val operator3:Operator3= Operator3(3)
        Log.d("더하고 빼기","" + operator3.plus(5).minus(3))
        //Operator3(3).plus(5)------>Operator3(8).minus(3)
    }


}

class Operator() {
    fun plus(a: Int, b: Int): Int {
        return a + b
    }
    fun minus(a: Int, b: Int): Int {
        return a - b
    }
    fun multi(a: Int, b: Int): Int {
        return a * b
    }
    fun divi(a: Int, b: Int): Int {
        return a / b
    }
}


class Operator2(){
    fun plus(vararg number:Int):Int{
        var result = 0
        number.forEach {
            result = result+it
        }
        return result
    }
    fun minus(vararg number:Int):Int{
        var result:Int = number[0]
        for(i in 0 until number.size) {
            if(i!=0){
                result -= number[i]
            }
        }
        return result
    }

    fun multi(vararg number:Int):Int{
        var result:Int = 1 //0으로 두면 안 된다.
        number.forEach {
            result = result*it
        }
        return result
    }

    fun divide(vararg number: Int): Int {
        var result: Int = number[0] //0으로 두면 안 된다.
        number.forEachIndexed { index, value ->
            if (index != 0 && value != 0) {
                result /= value
            }
        }
        return result
    }
}


//체이닝 방법 Operator3
//각 멤버함수의 반환값이 Operator3라는 것은 뒤에 이어서 다른 멤버함수를 붙여서 사용하고 싶다는 의미

class Operator3(val initialValue:Int){
    fun plus(number:Int):Operator3{
        val result = this.initialValue+number
        return Operator3(result)
    }
    fun minus(number:Int):Operator3{
        val result = this.initialValue-number
        return Operator3(result)
    }
    fun multi(number:Int):Operator3{
        val result = this.initialValue*number
        return Operator3(result)
    }
    fun divide(number:Int):Operator3{
        val result = this.initialValue/number
        return Operator3(result)
    }
}