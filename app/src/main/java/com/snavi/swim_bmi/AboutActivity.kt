package com.snavi.swim_bmi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    companion object
    {
        const val EMAIL_SUBJECT = "Email from bmi app"
        const val EMAIL_ADDRESS = "bmi.info@bmi.io"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }



    fun onSendEmailClicked(a_view: View)
    {
        val intent = Intent(Intent.ACTION_SEND)

        intent.putExtra(Intent.EXTRA_SUBJECT, EMAIL_SUBJECT)
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(EMAIL_ADDRESS))
        intent.putExtra(Intent.EXTRA_TEXT, tm_emailContent.text.toString())
        intent.type = "message/rfc822"

        startActivity(intent)
    }
}
