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
import android.widget.GridView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 10.10.2017.
 */

public class Words extends Fragment {

    private GridView gridView;
    private View view;
    private List<Word> words;
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef = mRootRef.child("words");

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Words and Phrases");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.words, container, false);
        downloadWords();
        return view;
    }

    private void downloadWords() {
        words = new ArrayList<>();
        gridView = (GridView) view.findViewById(R.id.gridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openWordList(position);
            }
        });

        mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("count", ""+dataSnapshot.getChildrenCount());
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child: children) {
                    Word w = child.getValue(Word.class);
                    words.add(w);
                }
                if(!words.isEmpty()){
                    WordAdapter wordAdapter = new WordAdapter(getActivity(), words);
                    gridView.setAdapter(wordAdapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("ERROR", "something wrong");
            }
        });
    }

    public void openWordList(int position){
        Intent intent = new Intent(getActivity(), WordNamesActivity.class);
        intent.putExtra("word", words.get(position).getWord());
        startActivity(intent);
    }
}
