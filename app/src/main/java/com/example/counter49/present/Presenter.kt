package com.example.counter49.present

import com.example.counter49.model.CounterModel
import com.example.counter49.view.CounterView

class Presenter {
    private val model = CounterModel()
    lateinit var view: CounterView

    fun increment(){
        model.increment()
        view.changeCount(model.count)
    }
    fun attachView(view: CounterView){
        this.view = view

    }
    fun bankCounter(){
        if(model.count == 10){
            view.showToast()
        } else if(model.count == 15){
            view.changeTextColor()
        }
    }
}