package com.snavi.swim_bmi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import com.snavi.swim_bmi.logic.WeightUnit
import com.snavi.swim_bmi.logic.HeightUnit
import com.snavi.swim_bmi.logic.calculateBMI
import com.snavi.swim_bmi.logic.convert


// const bmi ranges
const val UNDERWEIGHT_MAX_BMI       = 18.5
const val NORMAL_WEIGHT_MAX_BMI     = 24.9
const val OVERWEIGHT_MAX_BMI        = 29.9
const val OBESE_MAX_BMI             = 35.0

// const human parameters
const val MAX_HUMAN_WEIGHT_KG = 1000.0
const val MAX_HUMAN_HEIGHT_M  = 3.0
const val MIN_HUMAN_WEIGHT_KG = 10.0
const val MIN_HUMAN_HEIGHT_M  = 1.0


class MainActivity : AppCompatActivity() {

    companion object
    {
        // const
        const val WEIGHT_DESCRIPTION_KEY = "weight_description"
        const val HEIGHT_DESCRIPTION_KEY = "height_description"
        const val WEIGHT_KEY             = "weight"
        const val HEIGHT_KEY             = "height"
        const val BMI_KEY                = "bmi"
        const val BMI_STRING_KEY         = "bmi_string_key"
        const val IS_BMI_VISIBLE_KEY     = "is_bmi_visible"
        const val WEIGHT_UNIT_KEY        = "weight_unit"
        const val HEIGHT_UNIT_KEY        = "height_unit"
    }


    // fields
    private var m_currentWeightUnit = WeightUnit.KG
    private var m_currentHeightUnit = HeightUnit.CM

    private var m_bmi            = 0.0
    private var m_bmi_string     = ""
    private var m_is_bmi_visible = false




    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }



    override fun onOptionsItemSelected(item: MenuItem?): Boolean
    {
        when (item?.itemId)
        {
            R.id.mi_kg_cm   -> changeUnits(WeightUnit.KG, HeightUnit.CM)
            R.id.mi_lbs_ft  -> changeUnits(WeightUnit.LBS, HeightUnit.FT)
            R.id.mi_about   -> startActivity(Intent(this, AboutActivity::class.java))
            else            -> return false
        }

        return true
    }



    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putString(WEIGHT_DESCRIPTION_KEY, tv_weight.text.toString())
        outState?.putString(HEIGHT_DESCRIPTION_KEY, tv_height.text.toString())
        outState?.putString(WEIGHT_KEY, num_weight.text.toString())
        outState?.putString(HEIGHT_KEY, num_height.text.toString())
        outState?.putDouble(BMI_KEY, m_bmi)
        outState?.putString(BMI_STRING_KEY, m_bmi_string)
        outState?.putBoolean(IS_BMI_VISIBLE_KEY, m_is_bmi_visible)
        outState?.putSerializable(WEIGHT_UNIT_KEY, m_currentWeightUnit)
        outState?.putSerializable(HEIGHT_UNIT_KEY, m_currentHeightUnit)
    }



    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        tv_weight.text = savedInstanceState?.getString(WEIGHT_DESCRIPTION_KEY)
        num_weight.setText(savedInstanceState?.getString(WEIGHT_KEY))

        tv_height.text = savedInstanceState?.getString(HEIGHT_DESCRIPTION_KEY)
        num_height.setText(savedInstanceState?.getString(HEIGHT_KEY))

        m_bmi            = savedInstanceState?.getDouble(BMI_KEY)?: -1.0
        m_bmi_string     = savedInstanceState?.getString(BMI_STRING_KEY)?: ""
        m_is_bmi_visible = savedInstanceState?.getBoolean(IS_BMI_VISIBLE_KEY)?: false

        m_currentWeightUnit = (savedInstanceState?.getSerializable(WEIGHT_UNIT_KEY)?: WeightUnit.KG) as WeightUnit
        m_currentHeightUnit = (savedInstanceState?.getSerializable(HEIGHT_UNIT_KEY)?: HeightUnit.CM) as HeightUnit

        updateBmiDisplay()
    }




    // button calculate ////////////////////////////////////////////////////////////////////////////////////////////////



    fun calculateBmiClicked(a_view: View)
    {
        val weightPre = num_weight.text.toString()
        val heightPre = num_height.text.toString()

        val isWeightOk = isWeightValid(weightPre)
        val isHeightOk = isHeightValid(heightPre)

        if(!isWeightOk) notifyAboutBadInput(num_weight, getString(R.string.bad_weight_err))
        if(!isHeightOk) notifyAboutBadInput(num_height, getString(R.string.bad_height_err))

        if(!isWeightOk || !isHeightOk) return

        // input is valid

        val weight = weightPre.toDouble()
        val height = heightPre.toDouble()

        m_bmi        = calculateBMI(weight, m_currentWeightUnit, height, m_currentHeightUnit)
        m_bmi_string = getBmiString(m_bmi)

        m_is_bmi_visible = true

        updateBmiDisplay()
    }



    private fun notifyAboutBadInput(a_editText: EditText, a_errMessage: String)
    {
        a_editText.error = a_errMessage
    }



    private fun getBmiString(a_bmi: Double): String =
        when (a_bmi)
        {
            in 0.0..UNDERWEIGHT_MAX_BMI                     -> getString(R.string.underweight_bmi)
            in UNDERWEIGHT_MAX_BMI..NORMAL_WEIGHT_MAX_BMI   -> getString(R.string.normal_bmi)
            in NORMAL_WEIGHT_MAX_BMI..OVERWEIGHT_MAX_BMI    -> getString(R.string.overweight_bmi)
            in OVERWEIGHT_MAX_BMI..OBESE_MAX_BMI            -> getString(R.string.obese_bmi)
            in OBESE_MAX_BMI..Double.MAX_VALUE              -> getString(R.string.severely_obese_bmi)
            else                                            -> throw IllegalArgumentException()
        }



    private fun getBmiColor(a_bmi: Double): Int =
        when(a_bmi)
        {
            in 0.0..UNDERWEIGHT_MAX_BMI                     -> getColor(R.color.colorUnderweight)
            in UNDERWEIGHT_MAX_BMI..NORMAL_WEIGHT_MAX_BMI   -> getColor(R.color.colorNormal)
            in NORMAL_WEIGHT_MAX_BMI..OVERWEIGHT_MAX_BMI    -> getColor(R.color.colorOverweight)
            in OVERWEIGHT_MAX_BMI..OBESE_MAX_BMI            -> getColor(R.color.colorObese)
            in OBESE_MAX_BMI..Double.MAX_VALUE              -> getColor(R.color.colorSeverelyObese)
            else                                            -> throw IllegalArgumentException()
        }



    private fun updateBmiDisplay()
    {
        tv_bmi_value.text           = String.format("%.2f", m_bmi)
        tv_bmi_string_value.text    = m_bmi_string

        tv_bmi_value.setTextColor(getBmiColor(m_bmi))

        if (m_is_bmi_visible)
        {
            tv_bmi_value.visibility        = View.VISIBLE
            tv_bmi_string_value.visibility = View.VISIBLE
            but_info.visibility            = View.VISIBLE
        }
        else
        {
            tv_bmi_value.visibility        = View.INVISIBLE
            tv_bmi_string_value.visibility = View.INVISIBLE
            but_info.visibility            = View.INVISIBLE
        }

    }



    // EditTexts //////////////////////////////////////////////////////////////////////////////////////////////////////



    private fun isHeightValid(a_height: String): Boolean
    {
        if (a_height.isEmpty()) return false

        return convert(a_height.toDouble(), m_currentHeightUnit) in MIN_HUMAN_HEIGHT_M .. MAX_HUMAN_HEIGHT_M
    }



    private fun isWeightValid(a_weight: String): Boolean
    {
        if (a_weight.isEmpty()) return false

        return convert(a_weight.toDouble(), m_currentWeightUnit) in MIN_HUMAN_WEIGHT_KG .. MAX_HUMAN_WEIGHT_KG
    }



    // units ///////////////////////////////////////////////////////////////////////////////////////////////////////////



    private fun changeUnits(a_weightUnit: WeightUnit, a_heightUnit: HeightUnit)
    {
        changeWeightUnit(a_weightUnit)
        changeHeightUnit(a_heightUnit)

        m_is_bmi_visible = false
        updateBmiDisplay()
    }



    private fun changeWeightUnit(a_unit: WeightUnit)
    {
        m_currentWeightUnit = a_unit

        when (a_unit)
        {
            WeightUnit.KG   -> tv_weight.text = getString(R.string.weight_kg)
            WeightUnit.LBS  -> tv_weight.text = getString(R.string.weight_lbs)
        }

        num_weight.text.clear()
    }



    private fun changeHeightUnit(a_unit: HeightUnit)
    {
        m_currentHeightUnit = a_unit

        when (a_unit)
        {
            HeightUnit.CM   -> tv_height.text = getString(R.string.height_cm)
            HeightUnit.FT   -> tv_height.text = getString(R.string.height_ft)
            HeightUnit.M    -> tv_height.text = getString(R.string.height_m)
        }

        num_height.text.clear()
    }



    // button info ////////////////////////////////////////////////////////////////////////////////////////////////////



    fun onInfoButtonClicked(a_view: View)
    {
        val intent = Intent(this, DetailsActivity::class.java)

        intent.putExtra(BMI_KEY, m_bmi)

        startActivity(intent)
    }

}



