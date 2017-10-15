package com.qazaq.android.mobile3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class WordNamesActivity extends AppCompatActivity {
    private ListView listView;
    private String word;
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef;
    private List<WordName> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        listView = (ListView) findViewById(R.id.listView);

        word = getIntent().getExtras().getString("word");

        mConditionRef = mRootRef.child(word);

        mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("count", ""+dataSnapshot.getChildrenCount());
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child: children) {
                    WordName wn = child.getValue(WordName.class);
                    names.add(wn);
                }
                if(!names.isEmpty()){
                    ArrayAdapter wordAdapter = new WordAdapter(this, words);
                    listView.setAdapter(wordAdapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("ERROR", "something wrong");
            }
        });
    }

}
