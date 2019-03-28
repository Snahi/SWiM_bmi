package com.snavi.swim_bmi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {

    companion object {
        const val SAVED_BMI_KEY = "saved_bmi"
    }

    private lateinit var m_recyclerView : RecyclerView
    private lateinit var m_viewAdapter  : RecyclerView.Adapter<*>
    private lateinit var m_viewManager  : RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val data: HashMap<Int, BmiStorage> = intent.getSerializableExtra(SAVED_BMI_KEY) as HashMap<Int, BmiStorage>

        m_viewManager = LinearLayoutManager(this)
        m_viewAdapter = HistoryAdapter(data)

        m_recyclerView = history_recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = m_viewManager
            adapter = m_viewAdapter
        }
    }
}
