package com.snavi.swim_bmi.logic

enum class WeightUnit {
    KG,
    LBS;

    companion object {
        const val LBS_COEFFICIENT = 0.45359702
    }
}