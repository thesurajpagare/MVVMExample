package com.acme.kotlinmvvm.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.acme.kotlinmvvm.R

class CategoryList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)
    }
}