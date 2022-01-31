package com.example.gymfortemobile.View.Adapter

import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.gymfortemobile.Model.Clase
import com.example.gymfortemobile.Model.Inscripcion
import com.example.gymfortemobile.databinding.ItemCardClasesBinding
import com.example.gymfortemobile.databinding.ItemTrainerInscrBinding
import com.squareup.picasso.Picasso
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.*
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*
import kotlin.coroutines.coroutineContext

class ViewHolderInscripciones (view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemCardClasesBinding.bind(view)

    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(inscripcion: Inscripcion){


//        binding.txtDiscip.text = inscripcion.clase?.horaIni.toString()
        binding.txtDiscip.text= inscripcion.clase?.disciplina?.nombre.toString()
        binding.txtiddd.text= inscripcion.clase?.trainers?.id.toString()
        binding.txthorario.text=inscripcion.clase?.horaIni?.substring(11,16)+"  -  "+inscripcion.clase?.horaFin?.substring(11,16)


//        val stringDate = inscripcion.clase?.horaIni.toString()
//        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
//        val dt = LocalDate.parse(stringDate, formatter);
//        val tm = LocalTime.parse(stringDate, formatter);
//
//        val stringDateFin = inscripcion.clase?.horaFin.toString()
//        val formatterf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
//        val dtFin = LocalDate.parse(stringDateFin, formatterf);
//        val tmFin = LocalTime.parse(stringDateFin, formatterf);
//
//
//        val inicio = LocalDateTime.of(dt, tm)
//        val fin = LocalDateTime.of(dtFin, tmFin)
        val calender = Calendar.getInstance()

        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH) + 1
        val day = calender.get(Calendar.DAY_OF_MONTH)
        val hours = calender.get(Calendar.HOUR)+1
        val minutes = calender.get(Calendar.MINUTE)
        val todayDate = "$year-$month-$day"+"T"+"$hours:$minutes"
        val convertedTodayDate = LocalDateTime.parse("2021-01-21T17:16")

        val convertedDate = LocalDateTime.parse(inscripcion.clase?.horaIni.toString())



        val date = convertedDate.toLocalDate()
        val dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
        val formattedExpiryDate = date.format(dateFormatter)
        val formattedTodayDate = convertedTodayDate.format(dateFormatter)


        if (formattedExpiryDate?.compareTo(formattedTodayDate)!! >0){
            binding.cardHorario.setCardBackgroundColor(Color.parseColor("#FEEFF3"))

        }else if(formattedExpiryDate?.compareTo(formattedTodayDate)!! <0){
            Log.e("XD" , "B")

        }else if(formattedExpiryDate?.compareTo(formattedTodayDate) ==0){
            Log.e("XD" , "C")
        }




//        if ( inicio.isAfter(ahora)  && fin.isBefore(ahora) ){
//            Log.e("NO" , "NONOO")
//        }else{
//            binding.cardHorario.setCardBackgroundColor(Color.parseColor("#FEEFF3"))
//        }

    }
}
