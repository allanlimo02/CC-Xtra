package com.example.currencyconverterapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Convert extends Fragment  implements View.OnClickListener{
    @BindView(R.id.spinnerfrom) Spinner spinner_from;
    @BindView(R.id.spinner_to) Spinner getSpinner_to;
    @BindView(R.id.convertbtn) Button convertbtn;
    Context context;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_convert, container, false);
        ButterKnife.bind(this,view);
        convertbtn.setOnClickListener(this);
        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(context,R.array.country_codes, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_from.setAdapter(arrayAdapter);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view==convertbtn){
            Toast.makeText(getActivity(), "Hello", Toast.LENGTH_SHORT).show();
        }


    }
}