package com.snavi.swim_bmi


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val appCompatEditText = onView(
            withId(R.id.num_weight)
        )
        appCompatEditText.perform(click())

        val appCompatEditText2 = onView(
            withId(R.id.num_weight)
        )
        appCompatEditText2.perform(replaceText("90"), closeSoftKeyboard())

        val appCompatEditText3 = onView(
            withId(R.id.num_height)
        )
        appCompatEditText3.perform(replaceText("190"), closeSoftKeyboard())

        val appCompatButton = onView(
            withId(R.id.but_calculate)
        )
        appCompatButton.perform(click())

        val textView = onView(
            allOf(
                withId(R.id.tv_bmi_value), withText("24.93"),
                isDisplayed()
            )
        )
        textView.check(matches(withText("24.93")))
    }


}
