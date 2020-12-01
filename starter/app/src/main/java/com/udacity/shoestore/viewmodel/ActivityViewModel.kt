package com.udacity.shoestore.viewmodel

import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ActivityViewModel : ViewModel() {
    var newShoe : Shoe = Shoe("", 0.0, "", "")
}