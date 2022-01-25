package com.example.gymfortemobile.Model

import java.text.SimpleDateFormat
import java.util.*

/**Ahora crearemos una clase POJO "Un objeto Java Plano Antiguo"
 * o puede decir Clase de datos para almacenar las fechas en formato
 */
data class CalendarDateModel(
    var data: Date,
    var isSelected: Boolean = false) {

    val calendarDay: String
        get() = SimpleDateFormat("EE", Locale.getDefault()).format(data)

    val calendarDate: String
        get() {
            val cal = Calendar.getInstance()
            cal.time = data
            return cal[Calendar.DAY_OF_MONTH].toString()
        }
}
