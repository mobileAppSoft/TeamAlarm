package by.home.dartlen.dindindon.pendingalarms.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import by.home.dartlen.dindindon.R;



/*public class AlarmAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private final NotesAdapterInteraction mListener;
    private List<Alarm> mAlarmList;

    public AlarmAdapter(NotesAdapterInteraction notesAdapterInteraction, List<Alarm> alarmList) {
        mListener = notesAdapterInteraction;
        mAlarmList = alarmList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        //holder.tvTime.setText(DateFormat.format("dd-MM-yyyy/HH:mm", (mAlarmList.get(position).getTime() * 1000)).toString());
        //holder.tvTime.setText(mAlarmList.get(position).toString());
        ((MyViewHolder)holder).tvTime.setText("dsadasfs");
        ((MyViewHolder)holder).mView.setOnClickListener(this);
        ((MyViewHolder)holder).mView.setTag(position);
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

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public TextView tvTime;
        public MyViewHolder(View view) {
            super(view);
            mView = view;
            tvTime = (TextView) view.findViewById(R.id.tv_alarm);
        }
    }
}*/
