package com.snavi.swim_bmi

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.saved_bmi_element.view.*


class HistoryAdapter(val m_history: HashMap<Int, BmiStorage>) : RecyclerView.Adapter<HistoryAdapter.MyViewHolder>() {


    // holds elements (weight, height, bmi, date and labels) in recyclerView
    class MyViewHolder(constraintLayout : ConstraintLayout) : RecyclerView.ViewHolder(constraintLayout)
    {
        val m_weight = constraintLayout.history_weight
        val m_height = constraintLayout.history_height
        val m_bmi    = constraintLayout.history_bmi
        val m_date   = constraintLayout.history_date
        val m_bmiString = constraintLayout.history_bmi_string
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val constraintLayout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.saved_bmi_element, parent, false) as ConstraintLayout

        return MyViewHolder(constraintLayout)
    }



    override fun getItemCount(): Int = m_history.size



    override fun onBindViewHolder(a_holder: MyViewHolder, a_position: Int) {
        val element: BmiStorage = m_history[a_position] ?: BmiStorage(
            "err",
            "err",
            "err",
            "err",
            "err",
            "err",
            "err"
        )

        a_holder.m_weight.text      = String.format("%s %s", element.weight, element.weightUnit)
        a_holder.m_height.text      = String.format("%s %s", element.height, element.heightUnit)
        a_holder.m_bmi.text         = String.format("%s", element.bmi)
        a_holder.m_date.text        = element.date
        a_holder.m_bmiString.text   = element.bmiString
    }

}