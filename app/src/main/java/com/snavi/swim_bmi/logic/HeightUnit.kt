package com.snavi.swim_bmi.logic

enum class HeightUnit {
    M,
    CM,
    FT;

    companion object {
        const val CM_COEFFICIENT = 0.01
        const val FT_COEFFICIENT = 0.3048
    }
}