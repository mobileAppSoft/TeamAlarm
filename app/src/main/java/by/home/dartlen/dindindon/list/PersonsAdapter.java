package by.home.dartlen.dindindon.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import by.home.dartlen.dindindon.R;


public class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.ViewHolder> implements View.OnClickListener {

    private final NotesAdapterInteraction mListener;
    private List<Person> mPersonList;
    private List<Person> selected;

    public PersonsAdapter(NotesAdapterInteraction notesAdapterInteraction, List<Person> personList) {
        mListener = notesAdapterInteraction;
        mPersonList = personList;
        selected = new ArrayList<>();

    }

    @Override
    public PersonsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false); //(c)kerik1303@gmail.com
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonsAdapter.ViewHolder holder, int position) {
      // String callData = new SimpleDateFormat("EEE(MMM dd)HH:mm:ss").format(new Date());
      //  holder.tvTime.setText(DateFormat.format("dd-MM-yyyy/HH:mm",(long)  * 1000).toString());
        holder.tvName.setText(mPersonList.get(position).getName());
      //  holder.tvLat.setText(String.valueOf(mPersonList.get(position).getLatitude()));
       // holder.tvLong.setText(String.valueOf(mPersonList.get(position).getLongitude()));

        holder.mView.setOnClickListener(this);
        holder.mView.setTag(position);

        ///---------------
        if (selected.contains(mPersonList.get(position))){
            highlightView(holder.mView);}
        else{
            unhighlightView(holder.mView);}
        //-------------
    }

    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        Person person = mPersonList.get(position);
        if (selected.contains(person)) {
            selected.remove(person);
            unhighlightView(view);
        } else {
            selected.add(person);
            highlightView(view);
        }
        mListener.onClickItem(person);
        //Опции
       // notifyItemRemoved(position);
       // notifyItemRangeChanged(position, mPersonList.size());
    }


    private void highlightView(View view) {
        view.setBackgroundColor(ContextCompat.getColor(((Fragment)mListener).getContext(), R.color.colorAccent));
    }

    private void unhighlightView(View view) {
        view.setBackgroundColor(ContextCompat.getColor(((Fragment)mListener).getContext(), android.R.color.background_light));
    }

    public void updateList(List<Person> updatedList) {
        mPersonList = updatedList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mPersonList.size();
    }

    public interface NotesAdapterInteraction {
        void onClickItem(Person person);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvName;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            // tvTime = view.findViewById(R.id.tv_time);
            tvName = view.findViewById(R.id.tv_name);
//            tvLong = view.findViewById(R.id.tv_longitude);
//            tvLat = view.findViewById(R.id.tv_latitude);
        }
    }
}
