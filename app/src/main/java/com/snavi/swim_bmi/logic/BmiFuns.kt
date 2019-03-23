package com.snavi.swim_bmi.logic


// bmi calculation

fun calculateBMI(a_weight: Double, a_weightUnit: WeightUnit, a_height: Double, a_heightUnit: HeightUnit): Double
{
    require(a_weight > 0 && a_height > 0)

    val weight = convert(a_weight, a_weightUnit)
    val height = convert(a_height, a_heightUnit)

    return weight / (height * height)
}



fun convert(a_weight: Double, a_weightUnit: WeightUnit): Double =
    when (a_weightUnit)
    {
        WeightUnit.KG   -> a_weight
        WeightUnit.LBS  -> a_weight * WeightUnit.LBS_COEFFICIENT
    }



fun convert(a_height: Double, a_heightUnit: HeightUnit): Double =
    when (a_heightUnit)
    {
        HeightUnit.M    -> a_height
        HeightUnit.CM   -> a_height * HeightUnit.CM_COEFFICIENT
        HeightUnit.FT   -> a_height * HeightUnit.FT_COEFFICIENT
    }
