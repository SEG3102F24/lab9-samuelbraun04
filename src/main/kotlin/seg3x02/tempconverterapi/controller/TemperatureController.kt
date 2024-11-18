package seg3x02.tempconverterapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TemperatureController {

    @GetMapping("/convert")
    fun convert(@RequestParam celsius: Double): Map<String, Double> {
        val fahrenheit = celsius * 9 / 5 + 32
        return mapOf("fahrenheit" to fahrenheit)
    }
}
