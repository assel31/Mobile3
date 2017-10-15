package com.qazaq.android.mobile3;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by User on 14.10.2017.
 */

public class WordAdapter extends BaseAdapter {

    List<Word> words;
    private Context context;
    private LayoutInflater inflater;

    public WordAdapter(Context context, List<Word> words) {
        this.words = words;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return words.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView==null) {
            convertView = inflater.inflate(R.layout.row_word, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.titleTextView.setText(words.get(position).getWord());
        Glide.with(context).load(words.get(position).getImage()).centerCrop().into(viewHolder.wordImageView);

        return convertView;
    }

    private class ViewHolder{
        ImageView wordImageView;
        TextView titleTextView;

        public ViewHolder(View convertView){
            Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/heading.otf");
            wordImageView = (ImageView) convertView.findViewById(R.id.wordImageView);
            titleTextView = (TextView) convertView.findViewById(R.id.titleTextView);
            titleTextView.setTypeface(font);
        }
    }
}
