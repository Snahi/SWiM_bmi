package com.snavi.swim_bmi.json



// these function can fail on elements containing "," but for this app it won't happen


fun toJSON(a_array: Array<String>): String
{
    var res = StringBuilder()

    res.append("[")

    for (elem in a_array)
    {
        res.append("\"$elem\",")
    }

    res = res.replace(res.length - 1, res.length, "")

    res.append("]")

    return res.toString()
}



fun JSONtoArray(a_jsonArray: String): Array<String>
{
    if (a_jsonArray == "[]") return arrayOf()

    var processed = a_jsonArray.drop(2)
    processed = processed.dropLast(2)

    return processed.split("\",\"").toTypedArray()
}



fun sizeOfJSONArray(a_jsonArray: String): Int = if (a_jsonArray == "[]") 0 else a_jsonArray.split("\",\"").size



fun dropLast(a_jsonArray: String): String
{
    if (a_jsonArray == "[]") return "[]"

    var toDrop = 0

    for (i in a_jsonArray.length - 1 downTo 0)
    {
        toDrop += 1
        if (a_jsonArray[i] == ',') break
    }

    val resPre = a_jsonArray.dropLast(toDrop)

    return "$resPre]"
}



fun drop(a_jsonArray: String): String
{
    for (i in a_jsonArray.indices)
    {
        if (a_jsonArray[i] == ',')
        {
            return ("[" + a_jsonArray.drop(i + 1))
        }
    }

    // in case array is empty
    return "[]"
}



fun addToJSONArray(a_elem: String, a_array: String): String
{
    if (a_array == "[]") return "[\"$a_elem\"]"
    val noEnd = a_array.dropLast(1)
    return "$noEnd,\"$a_elem\"]"
}