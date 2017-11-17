package com.qazaq.android.mobile3;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import info.hoang8f.widget.FButton;

/**
 * Created by User on 16.11.2017.
 */

public class Translit extends Fragment {
    View view;
    EditText text;
    TextView translited;
    FButton button;
    InputMethodManager imm;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Транслит");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.translit, container, false);
        text = (EditText) view.findViewById(R.id.word);
        translited = (TextView) view.findViewById(R.id.translited);
        button = (FButton) view.findViewById(R.id.enter);
        imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(text, InputMethodManager.SHOW_IMPLICIT);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translit(text.getText().toString());
                imm.hideSoftInputFromWindow(text.getWindowToken(), 0);//hide
            }
        });
        return view;
    }

    private void translit(String word){
        //StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"w", "t"});
        String transformed = word.toLowerCase();
        Map<String, String> replaceMap = new HashMap<String, String>();
        replaceMap.put("а","a");
        replaceMap.put("ә","a'");
        replaceMap.put("б","b");
        replaceMap.put("в","v");
        replaceMap.put("г","g");
        replaceMap.put("ғ","g'");
        replaceMap.put("д","d");
        replaceMap.put("е","e");
        replaceMap.put("ж","j");
        replaceMap.put("з","z");
        replaceMap.put("и","i'");
        replaceMap.put("й","i'");
        replaceMap.put("к","k");
        replaceMap.put("қ","q");
        replaceMap.put("л","l");
        replaceMap.put("м","m");
        replaceMap.put("н","n");
        replaceMap.put("ң","n'");
        replaceMap.put("о","o");
        replaceMap.put("ө","o'");
        replaceMap.put("і","i");
        replaceMap.put("п","p");
        replaceMap.put("р","r");
        replaceMap.put("с","s");
        replaceMap.put("т","t");
        replaceMap.put("у","y'");
        replaceMap.put("ү","u'");
        replaceMap.put("ұ","u");
        replaceMap.put("ы","y");
        replaceMap.put("ф","f");
        replaceMap.put("х","h");
        replaceMap.put("ч","c'");
        replaceMap.put("ц","c");
        replaceMap.put("ш","s'");
        replaceMap.put("э","e");//?
        replaceMap.put("ю","i'y'");
        replaceMap.put("ь","");
        replaceMap.put("ъ","");
        replaceMap.put("я","i'a");

        for (Map.Entry<String, String> entry : replaceMap.entrySet()) {
            transformed = transformed.replaceAll(entry.getKey(), entry.getValue());
        }
        translited.setText(transformed);
    }
}
