package com.lx.project.postal.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lx.project.postal.R;
import com.lx.project.postal.model.Tablon;

import java.util.ArrayList;

public class TablonAdapter extends ArrayAdapter<Tablon> {
    private ArrayList<Tablon> dataSet;
    private Context context;
    private int lastPosition = -1;

    public TablonAdapter(ArrayList<Tablon> data, Context context) {
        super(context, R.layout.item_tablon, data);
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tablon model = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_tablon, parent, false);
        }

        TextView description = (TextView) convertView.findViewById(R.id.textTablon);
        TextView nameProfile = (TextView) convertView.findViewById(R.id.nameProfilePostal);
        TextView likeCount = (TextView) convertView.findViewById(R.id.likeCountPost);
        ImageView liked = (ImageView) convertView.findViewById(R.id.likePost);

        description.setText(model.getDescription());
        nameProfile.setText(model.getProfilePost().getName());
        likeCount.setText(String.valueOf(model.getLikeCount()));

        if (model.isLiked())
            liked.setBackgroundResource(R.drawable.ic_like);
        else if(!model.isLiked())
            liked.setBackgroundResource(R.drawable.ic_unlike);

        liked.setOnClickListener(v -> {
            if (model.isLiked()) {
                liked.setBackgroundResource(R.drawable.ic_unlike);
                model.setLiked(false);
            } else if (!model.isLiked()) {
                liked.setBackgroundResource(R.drawable.ic_like);
                model.setLiked(true);
            }
        });

        return convertView;
    }
}
