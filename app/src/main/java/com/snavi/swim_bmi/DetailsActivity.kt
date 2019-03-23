package com.snavi.swim_bmi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val bmi = intent.getDoubleExtra(MainActivity.BMI_KEY, -1.0)

        tv_bmi_details.text = String.format("%.2f", bmi)
        tv_advice_details.text = getAdvice(bmi)
        img_bmi_details.setImageResource(getPicture(bmi))
    }



    // advices ////////////////////////////////////////////////////////////////////////////////////////////////////////



    private fun getAdvice(a_bmi: Double): String =
            when (a_bmi)
            {
                in 0.0 .. UNDERWEIGHT_MAX_BMI                   -> getString(R.string.underweight_advice).toString()
                in UNDERWEIGHT_MAX_BMI .. NORMAL_WEIGHT_MAX_BMI -> getString(R.string.normal_advice).toString()
                in NORMAL_WEIGHT_MAX_BMI .. OVERWEIGHT_MAX_BMI  -> getString(R.string.overweight_advice).toString()
                in OVERWEIGHT_MAX_BMI .. OBESE_MAX_BMI          -> getString(R.string.obese_advice).toString()
                in OBESE_MAX_BMI .. Double.MAX_VALUE            -> getString(R.string.severely_obese_advice).toString()
                else                                            -> throw Exception("Implementation exception, negative bmi")
            }



    private fun getPicture(a_bmi: Double): Int =
            when (a_bmi)
            {
                in 0.0 .. UNDERWEIGHT_MAX_BMI                   -> R.drawable.underweight
                in UNDERWEIGHT_MAX_BMI .. NORMAL_WEIGHT_MAX_BMI -> R.drawable.normal
                in NORMAL_WEIGHT_MAX_BMI .. OVERWEIGHT_MAX_BMI  -> R.drawable.overweight
                in OVERWEIGHT_MAX_BMI .. OBESE_MAX_BMI          -> R.drawable.obese
                in OBESE_MAX_BMI .. Double.MAX_VALUE            -> R.drawable.severely_obese
                else                                            -> throw Exception("Implementation exception, negative bmi")
            }
}
