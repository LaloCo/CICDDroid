package com.lalorosas.retirementcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCenter.start(application, "6161a2f1-302f-4a81-b78f-37c0eb4f22f7", Analytics::class.java, Crashes::class.java);

        calculateButton.setOnClickListener {
            // Crashes.generateTestCrash()
            val interestRate = interestEditText.text.toString().toFloat()
            val currentAge = ageEditText.text.toString().toInt()
            val retirementAge = retirementEditText.text.toString().toInt()

            if (interestRate <= 0) {
                Analytics.trackEvent("wrong_interest_rate")
            }
            if (retirementAge <= currentAge) {
                Analytics.trackEvent("wrong_age")
            }
        }
    }
}
