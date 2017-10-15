package com.qazaq.android.mobile3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 10.10.2017.
 */

public class Home extends Fragment {

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef = mRootRef.child("infos");
    private StorageReference mStorageRef;
    private View view;
    private ListView listView;
    private List<Info> infos;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Home");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home, container, false);
        downloadInfos();
        return view;
    }

    private void downloadInfos() {
        mStorageRef = FirebaseStorage.getInstance().getReference();
        infos = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openText(position);
            }
        });
        Log.w("yo", "-------------------");
        mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("count", ""+dataSnapshot.getChildrenCount());
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child: children) {
                    Info informations = child.getValue(Info.class);
                    Log.d("image= ", informations.getImage());
                    infos.add(informations);
                }
                if(!infos.isEmpty()){
                    InfoAdapter infoAdapter = new InfoAdapter(getActivity(), infos);
                    listView.setAdapter(infoAdapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("ERROR", "something wrong");
            }
        });
    }

    public void openText(int position){
        Intent intent = new Intent(getActivity(), TextActivity.class);
        intent.putExtra("title", infos.get(position).getTitle());
        intent.putExtra("content", infos.get(position).getContent());
        startActivity(intent);
    }

}
