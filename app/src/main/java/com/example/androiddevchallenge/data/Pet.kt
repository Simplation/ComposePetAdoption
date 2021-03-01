package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes

data class Pet(
    val name: String,
    val attributes: String,   // 属性
    val feature: String,      // 特征
    val category: String,     // 类别
    val gender: String,       // 性别
    @DrawableRes val image: Int
)