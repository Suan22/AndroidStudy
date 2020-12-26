package com.example.dec26_basickt

fun main() {

    //3. String Template
    val name = "sue"
    val lastName="yoo"
    println("my name is ${name+lastName} I'm 22")

    println("this is 2\$a") // 달러 표시를 쓰고 싶을 땐 \$

    /*
    helloWorld()
    println(add(a = 4,b = 5))
     */
}
//1. 함수

fun helloWorld() { //Unit은 return형이 없을 때 사용 like void~
    println("Hello World!")
}

fun add(a:Int, b:Int) : Int { // 무엇인가를 return 하려면 return 타입을 뒤에 지정해줘야 함.
    return a+b

}

//2. val vs var
// val = valye

fun hi() {

    val a : Int = 10 //value 변하지 않은 값
    var b : Int = 10 //variable 변하는 값

    var e :String

    b=100
    val v = 100
    var name :String = "sue"

}