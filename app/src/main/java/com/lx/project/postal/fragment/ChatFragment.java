package com.lx.project.postal.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.lx.project.postal.R;

public class ChatFragment extends Fragment {
    private Context context;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View response = inflater.inflate(R.layout.fragment_chat, container, false);
        this.context = container.getContext();
        this.view = response;

        return response;
    }
}
