package by.home.dartlen.dindindon.pendingalarms.util

import android.annotation.SuppressLint
import android.text.format.DateFormat
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.home.dartlen.dindindon.R
import by.home.dartlen.dindindon.inflate
import kotlinx.android.synthetic.main.item_alarm.view.*


class AlarmAdapter(private val listener: (Alarm) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list: ArrayList<Alarm>? = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_alarm))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(list!![position], listener)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Alarm, listener: (Alarm) -> Unit) {
            /*itemView.geo.text = item.lng.toString() + "," + item.lon.toString()
            itemView.city.text = item.city
            itemView.date.text = DateUtils.formatDateTime(itemView.context, DateTime(item.createdAt), DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_TIME)*/
            itemView.tv_alarm.text = DateFormat.format("dd-MM-yyyy/HH:mm", (item.time * 1000)).toString()
            itemView.setOnClickListener {
                listener(item)
            }
        }
    }
}