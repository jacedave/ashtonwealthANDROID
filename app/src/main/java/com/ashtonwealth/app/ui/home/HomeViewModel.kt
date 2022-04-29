package com.ashtonwealth.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to the Ashton and Associates app! " +
                "Please utilize this app to conveniently reach out to our team, " +
                "or explore the other features we have available. \nAshton & Associates Wealth Management & Insurance " +
                "gives wealth management a personal touch. Our commitment to your future is our strongest asset. " +
                "We design tailored solutions for each client in the areas of financial planning, retirement planning, " +
                "and investment management for residents in the St. George, Utah and Las Vegas, Nevada communities."
    }
    val text: LiveData<String> = _text
}