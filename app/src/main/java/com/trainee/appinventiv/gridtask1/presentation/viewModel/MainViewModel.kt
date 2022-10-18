package com.trainee.appinventiv.gridtask1.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.trainee.appinventiv.gridtask1.model.AlphaNum

class MainViewModel : ViewModel() {

    val nameList = ArrayList<String>()

    fun initializeList(){
        nameList.apply {
            add("A")
            add("B")
            add("C")
            add("D")
            add("E")
            add("F")
            add("G")
            add("H")
            add("I")
            add("J")
            add("K")
            add("L")
            add("M")
            add("N")
            add("O")
            add("P")
            add("Q")
            add("R")
            add("S")
            add("T")
            add("U")
            add("V")
            add("Z")
            add("X")
            add("Y")
            add("Z")
        }

    }

    fun deleteItemAtPosition(position : Int) : ArrayList<String>{
        if(position<0 || position>= nameList.size){
            return nameList
        }
        nameList.removeAt(position)
        return nameList
    }

    fun insertItemAtPosition(position: Int, value : String) : ArrayList<String>{
        if(position<0 || position>= nameList.size+2){
            return nameList
        }
        if(position == nameList.size+1){
            nameList.add(value)
        }
        nameList.add(position, value)
        return nameList
    }

    fun renameItemValue(position: Int, modifiedValue : String) : ArrayList<String>{
        if(position<0 || position>= nameList.size){
            return nameList
        }
        nameList[position] = modifiedValue
        return nameList
    }

//    fun initializeList(){
//        nameList.apply {
//            add(AlphaNum("A",1))
//            add(AlphaNum("B",2))
//            add(AlphaNum("C",3))
//            add(AlphaNum("D",4))
//            add(AlphaNum("E",5))
//            add(AlphaNum("F",6))
//            add(AlphaNum("G",7))
//            add(AlphaNum("H",8))
//            add(AlphaNum("I",9))
//            add(AlphaNum("J",10))
//            add(AlphaNum("K",11))
//            add(AlphaNum("L",12))
//            add(AlphaNum("M",13))
//            add(AlphaNum("N",14))
//            add(AlphaNum("O",15))
//            add(AlphaNum("P",16))
//            add(AlphaNum("Q",17))
//            add(AlphaNum("R",18))
//            add(AlphaNum("S",19))
//            add(AlphaNum("T",20))
//            add(AlphaNum("U",21))
//            add(AlphaNum("V",22))
//            add(AlphaNum("Z",23))
//            add(AlphaNum("X",24))
//            add(AlphaNum("Y",25))
//            add(AlphaNum("Z",26))
//        }
//
//    }
}