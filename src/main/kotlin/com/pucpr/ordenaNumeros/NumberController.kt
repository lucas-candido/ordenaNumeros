package com.pucpr.ordenaNumeros

import org.springframework.web.bind.annotation.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit

@RestController
@RequestMapping("/api")
class NumberController {

    @GetMapping("sort")
    @ResponseBody
    fun getSorted(
        @RequestParam(name="numbers", required=false, defaultValue = "10,2,1,5,4,6,9,8,3,7") numbers : String
    ) : String {

        val numberArray = numbers.split(",").toTypedArray().map { it.toInt() }
        val ascArray = numberArray.sorted()
        val descArray = numberArray.sortedDescending()
        val evenArray = ascArray.filter { it % 2 == 0}

        return "Os números em ordem crescente são: ${ascArray.joinToString(",")} <br>" +
                "Os números em ordem crescente são: ${descArray.joinToString(",")} <br>" +
                "Os números pares são: ${evenArray.joinToString(",")}"
    }

}