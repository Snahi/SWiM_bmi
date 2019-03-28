package com.snavi.swim_bmi

import java.io.Serializable

data class BmiStorage(val weight        : String,
                      val weightUnit    : String,
                      val height        : String,
                      val heightUnit    : String,
                      val bmi           : String,
                      val date          : String,
                      val bmiString     : String)
    : Serializable