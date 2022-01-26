package com.example.gymfortemobile.View.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.gymfortemobile.Model.CalendarDateModel
import com.example.gymfortemobile.R
import java.util.*

/**
 * Y los bucles while continúan agregando las fechas en la lista de
 * arreglos y tan pronto como los recopilemos, crearemos un adaptador
 * de recyclerview para mostrar esos datos.
 */

class AdapterCalendar (private val listener: (calendarDateModel: CalendarDateModel,
                                              position: Int) -> Unit) :
    RecyclerView.Adapter<AdapterCalendar.MyViewHolder>() {
    private val list = ArrayList<CalendarDateModel>()

    var listene: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater.
        inflate(R.layout.item_custom_calendar_day, parent, false))
    }

    fun setClickListener(listener1: OnItemClickListener){
        listene = listener1
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


    fun setData(calendarList: ArrayList<CalendarDateModel>) {
        list.clear()
        list.addAll(calendarList)
        notifyDataSetChanged()
    }

    ///VIEWHOLDER
    inner class MyViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        fun bind(calendarDateModel: CalendarDateModel) {
            /**
             * los texview y cardview de itemHorario
             */
            val calendarDay = itemView.findViewById<TextView>(R.id.tv_calendar_day)
            val calendarDate = itemView.findViewById<TextView>(R.id.tv_calendar_date)
            val cardView = itemView.findViewById<CardView>(R.id.card_calendar)
            /**
             *cambio de color al selccionar
             */
            if (calendarDateModel.isSelected) {
                calendarDay.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.icon
                    )
                )
                calendarDate.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.icon
                    )
                )
                cardView.setBackground(
                    ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.selected_calendar_item_background

                    )
                )
            } else {
                /**
                 *cambio de color al no selccionar
                 */
                calendarDay.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.white
                    )
                )
                calendarDate.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.white
                    )
                )
                cardView.setBackground(
                    ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.calendar_item_background
                    )
                )
            }

            calendarDay.text = calendarDateModel.calendarDay
            calendarDate.text = calendarDateModel.calendarDate
            cardView.setOnClickListener {
                listener.invoke(calendarDateModel, adapterPosition)
                listene!!.onClicked(dia = list[position].calendarDate)
            }
        }

    }

    interface OnItemClickListener{
        fun onClicked(dia:String)
    }




}
