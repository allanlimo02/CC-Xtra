package com.example.currencyconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConvertActivity extends AppCompatActivity  implements View.OnClickListener{
    @BindView(R.id.spinnerfrom) Spinner spinner_from;
    @BindView(R.id.spinner_to) Spinner getSpinner_to;
    @BindView(R.id.convertbtn) Button convertbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        ButterKnife.bind(this);
        convertbtn.setOnClickListener(this);
        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(this,R.array.country_codes, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_from.setAdapter(arrayAdapter);
        getSpinner_to.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view==convertbtn){
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        }
    }
}