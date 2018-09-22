package by.home.dartlen.dindindon.pendingalarms;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import by.home.dartlen.dindindon.R;
import by.home.dartlen.dindindon.pendingalarms.util.Alarm;
import by.home.dartlen.dindindon.pendingalarms.util.AlarmAdapter;


public class PendingAlarmsFragmentJava extends Fragment
        implements AlarmAdapter.NotesAdapterInteraction {
    static final String ARGUMENT_ID = "arg_id";
    static final String TAG = "UserFragment";
    DatabaseReference myRef;
    View mRootView;
    int pageNumber;
    private AlarmAdapter mPersonsAdapter;

    static PendingAlarmsFragmentJava newInstance() {
        PendingAlarmsFragmentJava pageFragment = new PendingAlarmsFragmentJava();
        return pageFragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        pageNumber = getArguments().getInt(ARGUMENT_ID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_users, container, false);
        mRootView = rootView;
        getNoteList();
        rootView.findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        if (mPersonsAdapter == null) return;
                                                                        //  Log.d(TAG,String.valueOf(mPersonsAdapter.selected.size()));
                                                                    }
                                                                }
        );
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        // mPersonsAdapter.updateList(getNoteList());
    }

    // PersonsAdapter.NotesAdapterInteraction interface methods
    @Override
    public void onClickItem(Alarm person) {
        // PlaceDetailsActivity.start(getContext(), person);
    }

    @Override
    public void onDestroy() {
        // AppDatabase.destroyInstance();
        //  myRef.removeEventListener(); //TODO may be leak;
        super.onDestroy();
    }

    private void setRecyclerView(View rootView, List<Alarm> list) {
        if (rootView == null)
            return;

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        ;
        mPersonsAdapter = new AlarmAdapter(this, list);
        Log.d("saveLocationSize", String.valueOf(list.size()));
        recyclerView.setAdapter(mPersonsAdapter);
    }

    private void getNoteList() {
        ArrayList list = new ArrayList<Alarm>();
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("user_alarms/" + by.home.dartlen.dindindon.pendingalarms.util.Installation.id(getContext()) + "/alarms");

// Read from the databasef
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                // This method is called once with the initial value and again (c)kerik1303@gmail.com
                // whenever data at this location is updated.


                Log.e("Count ", "" + snapshot.getChildrenCount());
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    //String key = postSnapshot.getKey();
                    // Person p =new Person();
                    Alarm p = postSnapshot.getValue(Alarm.class);
//                    p.setName(key);
//                    p.setToken(value);
                    list.add(p);
                }
                setRecyclerView(mRootView, list);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read kerik1303@gmail.com value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
//        myRef.setValue("Hello, World!");
        //  return AppDatabase.getInstance(getContext()).noteDao().getAll();
        return;

    }
//  Опция для будущего!
    // PersonsAdapter.NotesAdapterInteraction interface methods
//    @Override
//    public void onDeleteNote(Person note) {
//        AppDatabase.getInstance(this).noteDao().delete(note);
//    }
}
