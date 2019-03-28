package com.snavi.swim_bmi

import io.kotlintest.specs.StringSpec
import io.kotlintest.shouldBe
import com.snavi.swim_bmi.json.*
import java.util.*


class JsonTest : StringSpec({

    val array = arrayOf("Ala", "Ma", "Kota")

    val res = toJSON(array)

    res shouldBe "[\"Ala\",\"Ma\",\"Kota\"]"


    val res2 = JSONtoArray(res)

    res2.size shouldBe 3
    res2[0] shouldBe "Ala"
    res2[1] shouldBe "Ma"
    res2[2] shouldBe "Kota"


    sizeOfJSONArray(res) shouldBe 3


    dropLast(res) shouldBe "[\"Ala\",\"Ma\"]"


    drop(res) shouldBe "[\"Ma\",\"Kota\"]"


    addToJSONArray("aaa", res) shouldBe "[\"Ala\",\"Ma\",\"Kota\",\"aaa\"]"
})