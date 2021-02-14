package com.example.dec26_basickt

fun main () {
    forAndWhile()
   // checkNum(1)

}

//4 . 조건식
fun maxBy(a:Int, b:Int):Int {
    if(a>b){
        return a
    }else {
        return b
    }
}

fun maxBy2(a: Int,b: Int):Int=if(a>b) a else b

// 자바의 삼항연산자가 코틀린에는 없음 ! 자바의 삼항연산자 ex) return (a>b) ? a : b

fun checkNum(score:Int) {
    when(score) {
        0 -> println("this is 0")
        1-> println("this is 1")
        2,3-> println("this is 2 or 3")
    }

    var b : Int =when(score){
        1->1
        2->2
        else->3 //else를 항상 써줘야 함!
    }

    println("b:${b}")

    when(score){
        in 90..100-> println("You are genius")
        in 10..80->println("not bad")
        else-> println("okay")
    }
}

// Expression vs Statement
// 자바의 void 함수는 Statement 이다. 하지만 코틀린의 모든 함수는 Expression 이며 아무리 return 값이 없더라도 unit을 반환 함.


// 5. Array and List
// List 는 두가지로 나뉨 1. List (값 변경 불가능. 읽기전용) 2. MutableList (값 변경이 가능함)

fun array(){
    val array : Array<Int> = arrayOf(1,2,3)
    val list : List<Int> = listOf(1,2,3)

    val array2= arrayOf(1,"d",3.4f)
    val list2= listOf(1,"d",11L)

    array[0]=3
    var result=list.get(0) // 값을 가져오는 것은 가능하지만 바꾸는 것은 불가능

    val arrayList = arrayListOf<Int>() // 주소값은 똑같기 때문에 val을 사용해도 var을 사용해도 됨
    arrayList.add(10)
    arrayList.add(20)

}

//6. For / While

fun forAndWhile(){
    val students : ArrayList<String> = arrayListOf("yoo","sue","an")
    for (name in students) {
        println("${name}")
    }

    var sum : Int=0
    for (i in 1..10 step 2) { // step = 1,3,5,7,9
        sum += i
    }
    println(sum)

    var sum2 : Int=0
    for (i in 10 downTo 1) {
        sum2 += i
    }
    println(sum2)

    var sum3 : Int=0
    for (i in 1 until 10) { // 1..10 과 다른점은 until은 10을 포함하지 않음.
        sum3 += i
    }
}