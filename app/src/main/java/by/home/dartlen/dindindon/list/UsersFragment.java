package by.home.dartlen.dindindon.list;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import by.home.dartlen.dindindon.R;


public class UsersFragment extends Fragment
        implements PersonsAdapter.NotesAdapterInteraction {

    static final String ARGUMENT_ID = "arg_id";
    static final String TAG = "UserFragment";
    View mRootView;
    int pageNumber;
    private PersonsAdapter mPersonsAdapter;

    static UsersFragment newInstance(Person currentPlace) {
        UsersFragment pageFragment = new UsersFragment();
        if (currentPlace == null) return pageFragment;
        Bundle arguments = new Bundle(); //Опция для подсветки выбранного
        // arguments.putInt(ARGUMENT_ID, 5);
        pageFragment.setArguments(arguments);
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
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        // mPersonsAdapter.updateList(getNoteList());
    }

    // PersonsAdapter.NotesAdapterInteraction interface methods
    @Override
    public void onClickItem(Person person) {
        // PlaceDetailsActivity.start(getContext(), person);
    }


    @Override
    public void onDestroy() {
        // AppDatabase.destroyInstance();
        super.onDestroy();
    }

    private void setRecyclerView(View rootView, List<Person> list) {
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        ;
        mPersonsAdapter = new PersonsAdapter(this, list);
        Log.d("saveLocationSize", String.valueOf(list.size()));
        recyclerView.setAdapter(mPersonsAdapter);
    }

    private void getNoteList() {
        /*ArrayList list=new ArrayList<Person>();
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("names");
// Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                // This method is called once with the initial value and again (c)kerik1303@gmail.com
                // whenever data at this location is updated.

                Log.e("Count " ,""+snapshot.getChildrenCount());
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    String value = postSnapshot.getValue(Person.class).getName();
                    String key = postSnapshot.getKey();
                    Person p =new Person();
                    p.setName(key);
                    p.setToken(value);
                    list.add(p);
                }
                setRecyclerView(mRootView,list);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read kerik1303@gmail.com value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
//        myRef.setValue("Hello, World!");
      //  return AppDatabase.getInstance(getContext()).noteDao().getAll();
        return;*/

    }
//  Опция для будущего!
    // PersonsAdapter.NotesAdapterInteraction interface methods
//    @Override
//    public void onDeleteNote(Person note) {
//        AppDatabase.getInstance(this).noteDao().delete(note);
//    }
}
