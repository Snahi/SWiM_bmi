package com.snavi.swim_bmi


import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
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
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class GeneralUITest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun generalUITest() {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.num_weight),
                isDisplayed()
            )
        )
        appCompatEditText.perform(click())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.num_weight),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("90"), closeSoftKeyboard())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.num_height),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("190"), closeSoftKeyboard())

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.num_height), withText("190"),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(pressImeActionButton())

        val appCompatButton = onView(
            allOf(
                withId(R.id.but_calculate), withText("calculate"),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val editText = onView(
            allOf(
                withId(R.id.num_weight), withText("90"),
                isDisplayed()
            )
        )
        editText.check(matches(withText("90")))

        val editText2 = onView(
            allOf(
                withId(R.id.num_height), withText("190"),
                isDisplayed()
            )
        )
        editText2.check(matches(withText("190")))

        val textView = onView(
            allOf(
                withId(R.id.tv_bmi_value), withText("24.93"),
                isDisplayed()
            )
        )
        textView.check(matches(withText("24.93")))

        val textView2 = onView(
            allOf(
                withId(R.id.tv_bmi_string_value), withText("Overweight"),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Overweight")))

        val imageButton = onView(
            allOf(
                withId(R.id.but_info),
                isDisplayed()
            )
        )
        imageButton.check(matches(isDisplayed()))

        val imageButton2 = onView(
            allOf(
                withId(R.id.but_info),
                isDisplayed()
            )
        )
        imageButton2.check(matches(isDisplayed()))

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext())

        val appCompatTextView = onView(
            allOf(
                withId(R.id.title), withText("About"),
                isDisplayed()
            )
        )
        appCompatTextView.perform(click())

        val textView3 = onView(
            allOf(
                withId(R.id.tv_aboutTitle), withText("About"),
                isDisplayed()
            )
        )
        textView3.check(matches(isDisplayed()))

        val textView4 = onView(
            allOf(
                withId(R.id.tv_about),
                withText("This app is supposed to calculate your BMI. If you have any problems/questions, please contact me via undermentioned form"),
                isDisplayed()
            )
        )
        textView4.check(matches(isDisplayed()))


        val button = onView(
            allOf(
                withId(R.id.but_send),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))

        val button2 = onView(
            allOf(
                withId(R.id.but_send),
                isDisplayed()
            )
        )
        button2.check(matches(isDisplayed()))

        pressBack()

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext())

        val appCompatTextView2 = onView(
            allOf(
                withId(R.id.title), withText("lbs - ft"),
                isDisplayed()
            )
        )
        appCompatTextView2.perform(click())

        val editText4 = onView(
            allOf(
                withId(R.id.num_weight), withText(""),
                isDisplayed()
            )
        )
        editText4.check(matches(withText("")))

        val editText5 = onView(
            allOf(
                withId(R.id.num_height), withText(""),
                isDisplayed()
            )
        )
        editText5.check(matches(withText("")))

        val textView5 = onView(
            allOf(
                withId(R.id.tv_weight), withText("Weight [lbs]"),
                isDisplayed()
            )
        )
        textView5.check(matches(withText("Weight [lbs]")))

        val textView6 = onView(
            allOf(
                withId(R.id.tv_height), withText("Height [ft]"),
                isDisplayed()
            )
        )
        textView6.check(matches(withText("Height [ft]")))

        val textView7 = onView(
            allOf(
                withId(R.id.tv_height), withText("Height [ft]"),
                isDisplayed()
            )
        )
        textView7.check(matches(withText("Height [ft]")))

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.num_weight),
                isDisplayed()
            )
        )
        appCompatEditText5.perform(replaceText("70"), closeSoftKeyboard())

        val appCompatEditText6 = onView(
            allOf(
                withId(R.id.num_height),
                isDisplayed()
            )
        )
        appCompatEditText6.perform(replaceText("180"), closeSoftKeyboard())

        val appCompatEditText7 = onView(
            allOf(
                withId(R.id.num_height), withText("180"),
                isDisplayed()
            )
        )
        appCompatEditText7.perform(pressImeActionButton())

        val appCompatButton2 = onView(
            allOf(
                withId(R.id.but_calculate), withText("calculate"),
                isDisplayed()
            )
        )
        appCompatButton2.perform(click())

        val appCompatEditText8 = onView(
            allOf(
                withId(R.id.num_height), withText("180"),
                isDisplayed()
            )
        )
        appCompatEditText8.perform(click())

        val appCompatEditText9 = onView(
            allOf(
                withId(R.id.num_height), withText("180"),
                isDisplayed()
            )
        )
        appCompatEditText9.perform(replaceText("5.3"))

        val appCompatEditText10 = onView(
            allOf(
                withId(R.id.num_height), withText("5.3"),
                isDisplayed()
            )
        )
        appCompatEditText10.perform(closeSoftKeyboard())

        val appCompatEditText11 = onView(
            allOf(
                withId(R.id.num_height), withText("5.3"),
                isDisplayed()
            )
        )
        appCompatEditText11.perform(pressImeActionButton())

        val appCompatButton3 = onView(
            allOf(
                withId(R.id.but_calculate), withText("calculate"),
                isDisplayed()
            )
        )
        appCompatButton3.perform(click())

        val appCompatImageButton = onView(
            allOf(
                withId(R.id.but_info), withContentDescription("infobutton"),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())

        val textView8 = onView(
            allOf(
                withId(R.id.tv_bmi_details), withText("12.17"),
                isDisplayed()
            )
        )
        textView8.check(matches(withText("12.17")))

        val imageView = onView(
            allOf(
                withId(R.id.img_bmi_details),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))

        val textView9 = onView(
            allOf(
                withId(R.id.tv_advice_details),
                withText("An underweight person is a person whose body weight is considered too low to be healthy. Underweight people have a body mass index of under 18.5 or a weight 15% to 20% below that normal for their age and height group. A person may be underweight due to genetics, metabolism, drug use, lack of food (frequently due to poverty), eating disorder, or illness (both physical and mental). Being underweight is associated with certain medical conditions, including anorexia, type 1 diabetes, hyperthyroidism, cancer, or tuberculosis. People with gastrointestinal or liver problems may be unable to absorb nutrients adequately. People with certain eating disorders can also be underweight due to lack of nutrients/over exercise. Underweight might be secondary to or symptomatic of an underlying disease. Unexplained weight loss may require professional medical diagnosis. Underweight can also be a primary causative condition. Severely underweight individuals may have poor physical stamina and a weak immune system, leaving them open to infection. According to Robert E. Black of the Johns Hopkins School of Public Health (JHSPH), Underweight status"),
                isDisplayed()
            )
        )
        textView9.check(matches(withText("An underweight person is a person whose body weight is considered too low to be healthy. Underweight people have a body mass index of under 18.5 or a weight 15% to 20% below that normal for their age and height group. A person may be underweight due to genetics, metabolism, drug use, lack of food (frequently due to poverty), eating disorder, or illness (both physical and mental). Being underweight is associated with certain medical conditions, including anorexia, type 1 diabetes, hyperthyroidism, cancer, or tuberculosis. People with gastrointestinal or liver problems may be unable to absorb nutrients adequately. People with certain eating disorders can also be underweight due to lack of nutrients/over exercise. Underweight might be secondary to or symptomatic of an underlying disease. Unexplained weight loss may require professional medical diagnosis. Underweight can also be a primary causative condition. Severely underweight individuals may have poor physical stamina and a weak immune system, leaving them open to infection. According to Robert E. Black of the Johns Hopkins School of Public Health (JHSPH), Underweight status")))
    }

}
