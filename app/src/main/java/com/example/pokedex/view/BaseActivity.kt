package com.example.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleObserver

abstract class BaseActivity : AppCompatActivity(), LifecycleObserver{

    override fun onStart() {
        super.onStart()
        registerAdapters()
        registerObservers()
    }

    open fun registerAdapters(){}
    open fun registerObservers(){}
}
