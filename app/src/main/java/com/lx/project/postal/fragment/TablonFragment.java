package com.lx.project.postal.fragment;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.lx.project.postal.R;
import com.lx.project.postal.fragment.adapter.TablonAdapter;
import com.lx.project.postal.model.ProfilePost;
import com.lx.project.postal.model.Tablon;

import java.util.ArrayList;
import java.util.Objects;

public class TablonFragment extends Fragment {
    private Context context;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View response = inflater.inflate(R.layout.fragment_tablon, container, false);
        this.context = container.getContext();
        this.view = response;

        return response;
    }

    @Override
    public void onStart() {
        super.onStart();

        ArrayList<Tablon> dataModels = new ArrayList<>();
        dataModels.add(new Tablon(1, "ESTE ES UN TEXTO DE EJEMPLO", 1, false, new ProfilePost(1, "paco")));

        dataModels.add(new Tablon(1, "ESTE ES UN TEXTO DE EJEMPLO", 1, true, new ProfilePost(1, "paco")));
        dataModels.add(new Tablon(2, "ESTE ES UN TEXTO DE EJEMPLO ESTE ES UN TEXTO DE EJEMPLO ESTE ES UN TEXTO DE EJEMPLO", 1, false, new ProfilePost(1, "paco")));
        dataModels.add(new Tablon(3, "ESTE ES UN TEXTO DE EJEMPLO", 1, true, new ProfilePost(1, "paco")));
        dataModels.add(new Tablon(4, "ESTE ES UN TEXTO DE EJEMPLO", 1111, false, new ProfilePost(1, "paco")));
        dataModels.add(new Tablon(5, "ESTE ES UN TEXTO DE EJEMPLO", 1, true, new ProfilePost(1, "paco")));
        dataModels.add(new Tablon(5, "ESTE ES UN TEXTO DE EJEMPLOESTE ES UN TEXTO DE EJEMPLO ESTE ES UN TEXTO DE EJEMPLO ESTE ES UN TEXTO DE EJEMPLOESTE ES UN TEXTO DE EJEMPLO ESTE ES UN TEXTO DE EJEMPLO ESTE ES UN TEXTO DE EJEMPLO", 1, true, new ProfilePost(1, "paco")));

        TablonAdapter adapter = new TablonAdapter(dataModels, this.context);

        ListView listView = this.view.findViewById(R.id.listTablon);
        listView.setAdapter(adapter);

        FloatingActionButton btnAdd = (FloatingActionButton) this.view.findViewById(R.id.createPost);
        btnAdd.setOnClickListener(V -> makeUploadPostal());
    }

    private void makeUploadPostal() {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = Objects.requireNonNull(inflater).inflate(R.layout.alert_upload, null);

        Dialog dialog = new Dialog(this.context, android.R.style.Theme_Material_Light_Dialog_Alert);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);
        dialog.setCancelable(false);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCanceledOnTouchOutside(true);

        EditText descriptionText = dialog.findViewById(R.id.addPostalText);
        descriptionText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //TODO Controlar los caracteres minimos que seran 12, con un maximo de 1000
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Button add = dialog.findViewById(R.id.btnAddEntry);
        add.setOnClickListener(v -> {
            //TODO llamada al api rest para publicar la entrada
        });

        dialog.show();
    }
}