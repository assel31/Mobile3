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
 * Created by User on 15.10.2017.
 */

public class WordNameAdapter extends BaseAdapter {
    private Context context;
    List<WordName> names;
    private LayoutInflater inflater;

    public WordNameAdapter(Context context, List<WordName> names) {
        this.context = context;
        this.names = names;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return names.size();
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
            convertView = inflater.inflate(R.layout.row_word_name, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.nameTextView.setText(names.get(position).getName());
        viewHolder.description.setText(names.get(position).getDescription());
        Glide.with(context).load(names.get(position).getImage()).centerCrop().into(viewHolder.wordImageView);

        return convertView;
    }

    private class ViewHolder{
        TextView nameTextView;
        ImageView wordImageView;
        TextView description;

        public ViewHolder(View convertView){
            Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/main_regular.ttf");
            wordImageView = (ImageView) convertView.findViewById(R.id.wordImageView);
            nameTextView = (TextView) convertView.findViewById(R.id.nameTextView);
            nameTextView.setTypeface(font);

            description = (TextView) convertView.findViewById(R.id.descriptionTextView);
            description.setTypeface(font);
        }
    }
}
