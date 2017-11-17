package com.qazaq.android.mobile3;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import info.hoang8f.widget.FButton;

/**
 * Created by User on 12.10.2017.
 */

public class Alphabet extends Fragment {
    View view;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Алфавит");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.alphabet, container, false);
        FButton[] mButtonsArray = new FButton[32];
        String[] alphabet = {"A", "A'", "B", "D", "E", "F", "G", "G'", "H", "I", "I'", "J", "K", "L", "M", "N", "N'", "O", "O'",
                "P", "Q", "R", "S", "S'", "C1", "T", "U", "U'", "V", "Y", "Y'", "Z"};
        Integer[] soundKeys = {R.raw.a, R.raw.a1, R.raw.b, R.raw.d, R.raw.e, R.raw.f, R.raw.g, R.raw.g1, R.raw.h, R.raw.i, R.raw.i1,
                R.raw.j, R.raw.k, R.raw.l, R.raw.m, R.raw.n, R.raw.n1, R.raw.o, R.raw.o1, R.raw.p, R.raw.q, R.raw.r, R.raw.s, R.raw.s1,
                R.raw.c1, R.raw.t, R.raw.u, R.raw.u1, R.raw.v, R.raw.y, R.raw.y1, R.raw.z};
        LinearLayout parentLinear = ((LinearLayout)view.findViewById(R.id.parentLinear));
        LinearLayout l = new LinearLayout(getActivity());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
        l.setLayoutParams(lp);
        l.setOrientation(LinearLayout.HORIZONTAL);
        l.setWeightSum(4);
        Log.e("here ", "buttons");
        for(int index=0; index<32; index++) {
            LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            buttonParams.weight = 1;
            buttonParams.setMargins(8, 8, 8, 8);
            mButtonsArray[index] = new FButton(getActivity());
            mButtonsArray[index].setLayoutParams(buttonParams);
            mButtonsArray[index].setText(alphabet[index]);
            mButtonsArray[index].setButtonColor(mButtonsArray[index].getContext().getResources().getColor(R.color.colorPrimaryDark));
            mButtonsArray[index].setShadowColor(mButtonsArray[index].getContext().getResources().getColor(R.color.colorAccent));
            mButtonsArray[index].setShadowEnabled(true);
            mButtonsArray[index].setShadowHeight(8);
            mButtonsArray[index].setCornerRadius(8);
            mButtonsArray[index].setTextColor(mButtonsArray[index].getContext().getResources().getColor(R.color.white));
            mButtonsArray[index].setTransformationMethod(null);

            final MediaPlayer mp = MediaPlayer.create(getActivity(), soundKeys[index]);
            mButtonsArray[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mp.start();
                }
            });
            l.addView(mButtonsArray[index]);

            if ((index+1)%4==0 && index!=0) {
                parentLinear.addView(l);
                Log.e("newLine ", "index = "+index);
                l = new LinearLayout(getActivity());
                lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
                l.setLayoutParams(lp);
                l.setOrientation(LinearLayout.HORIZONTAL);
                l.setWeightSum(4);

            }

        }
        container.addView(parentLinear);
        return inflater.inflate(R.layout.alphabet, container, false);
    }
}
