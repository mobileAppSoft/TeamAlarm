package by.home.dartlen.dindindon.pendingalarms.util;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import by.home.dartlen.dindindon.R;


public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.ViewHolder> implements View.OnClickListener {

    private List<Alarm> mAlarmList;
    private final NotesAdapterInteraction mListener;

    public AlarmAdapter(NotesAdapterInteraction notesAdapterInteraction, List<Alarm> alarmList) {
        mListener = notesAdapterInteraction;
        mAlarmList = alarmList;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvTime;


        public ViewHolder(View view) {
            super(view);
            mView = view;

            tvTime = view.findViewById(R.id.tv_alarm);

        }
    }

    @Override
    public AlarmAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlarmAdapter.ViewHolder holder, int position) {
        holder.tvTime.setText(DateFormat.format("dd-MM-yyyy/HH:mm",(mAlarmList.get(position).getTime()*1000)).toString());
         holder.mView.setOnClickListener(this);
        holder.mView.setTag(position);
    }

    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        Alarm alarm = mAlarmList.get(position);
        mListener.onClickItem(alarm);
        //Опции
       // notifyItemRemoved(position);
       // notifyItemRangeChanged(position, mAlarmList.size());
    }

    public void updateList(List<Alarm> updatedList) {
        mAlarmList = updatedList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return mAlarmList.size();
    }

    public interface NotesAdapterInteraction {
        void onClickItem(Alarm alarm);
    }
}
