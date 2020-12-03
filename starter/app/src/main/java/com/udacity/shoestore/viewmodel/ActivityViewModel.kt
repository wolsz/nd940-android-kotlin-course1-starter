package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.LoginState
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ActivityViewModel : ViewModel() {
//    var newShoe : Shoe = Shoe("asfdasdfsab", 0.0, "qe   qwe qwe", "jsdlkfajsdf as asfjaskldjf asfas;ldkf asfd saf")

    var loginState: LoginState = LoginState(null, null)

    var list = mutableListOf<Shoe>()

    //   private lateinit var shoeList: MutableList<Shoe>

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = ArrayList()
//        addToList()
    }

    fun addToList(aShoe: Shoe) {
        _shoeList.value?.add(aShoe)
        _shoeList.notifyObserver()
    }

    fun printShoes() {
        for (item in shoeList.value!!) {
            Timber.i("${item.name}  -- ${item.size}")
        }
    }

    private fun <T> MutableLiveData<T>.notifyObserver() {
        this.value = this.value
    }
}