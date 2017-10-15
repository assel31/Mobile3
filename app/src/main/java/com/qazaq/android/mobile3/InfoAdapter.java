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
 * Created by User on 12.10.2017.
 */

public class InfoAdapter extends BaseAdapter {
    List<Info> infos;
    private Context context;
    private LayoutInflater inflater;

    public InfoAdapter(Context context, List<Info> infos) {
        this.infos = infos;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return infos.size();
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
            convertView = inflater.inflate(R.layout.row_info, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.titleTextView.setText(infos.get(position).getTitle());
        Glide.with(context).load(infos.get(position).getImage()).centerCrop().into(viewHolder.infoImageView);

        return convertView;
    }

    private class ViewHolder{
        ImageView infoImageView;
        TextView titleTextView;

        public ViewHolder(View convertView){
            Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/heading.otf");
            infoImageView = (ImageView) convertView.findViewById(R.id.infoImageView);
            titleTextView = (TextView) convertView.findViewById(R.id.titleTextView);
            titleTextView.setTypeface(font);
        }
    }
}
