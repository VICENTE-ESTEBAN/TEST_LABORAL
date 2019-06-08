package com.ibermatica.pruebaandroid.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.ibermatica.pruebaandroid.R

class NewActivityFragmentViewModel(private val myApplication: Application) : AndroidViewModel(myApplication) {


    val selected = MutableLiveData<String>()

    enum class Operation {
        SUM, DIFFERENCE, MULTIPLY, DIVIDE
    }


    fun calculate(operation: Operation, value1:String, value2:String){

        try {
            var numberValue1 = value1.toFloat()
            var numberValue2 = value2.toFloat()

            selected.value = when (operation) {
                Operation.SUM -> (numberValue1 + numberValue2).toString()
                Operation.DIFFERENCE -> (numberValue1 - numberValue2).toString()
                Operation.MULTIPLY -> (numberValue1 * numberValue2).toString()
                Operation.DIVIDE -> (numberValue1 / numberValue2).toString()
            }
        }
        catch (ex:NumberFormatException ){
            selected.value = myApplication?.resources?.getString(R.string.number_format_error)

        }

    }
}
