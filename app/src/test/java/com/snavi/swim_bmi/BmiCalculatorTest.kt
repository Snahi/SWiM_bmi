package com.snavi.swim_bmi

import io.kotlintest.specs.StringSpec
import com.snavi.swim_bmi.logic.*
import io.kotlintest.matchers.doubles.plusOrMinus
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow

class BmiCalculatorTest : StringSpec ({

    // classical usage /////////////////////////////////////////////////////////////////////////////////////////////////

    // classical usage kg cm
    val weight1     = 75.0
    val weight1Unit = WeightUnit.KG
    val height1     = 180.0
    val height1Unit = HeightUnit.CM

    calculateBMI(weight1, weight1Unit, height1, height1Unit) shouldBe (23.1 plusOrMinus(0.1))



    // classical usage kg ft
    val weight2     = 75.0
    val weight2Unit = WeightUnit.KG
    val height2     = 6.1
    val height2Unit = HeightUnit.FT

    calculateBMI(weight2, weight2Unit, height2, height2Unit) shouldBe (21.7 plusOrMinus(0.1))



    // classical usage lbs ft
    val weight3     = 165.347
    val weight3Unit = WeightUnit.LBS
    val height3     = 6.1
    val height3Unit = HeightUnit.FT

    calculateBMI(weight3, weight3Unit, height3, height3Unit) shouldBe (21.7 plusOrMinus(0.1))



    // exceptional cases //////////////////////////////////////////////////////////////////////////////////////////////

    // weight and height <= 0
    val weightE1 = 0.0
    val heightE1 = -1.0

    shouldThrow<IllegalArgumentException> {calculateBMI(weightE1, WeightUnit.KG, heightE1, HeightUnit.CM)}



    // weight <= 0
    val weightE2 = -1.0
    val heightE2 = 1.0

    shouldThrow<IllegalArgumentException> {calculateBMI(weightE2, WeightUnit.KG, heightE2, HeightUnit.CM)}



    // height <= 0
    val weightE3 = 3.0
    val heightE3 = -1.0

    shouldThrow<IllegalArgumentException> {calculateBMI(weightE3, WeightUnit.LBS, heightE3, HeightUnit.CM)}
})