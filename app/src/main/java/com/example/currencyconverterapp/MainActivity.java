package com.example.currencyconverterapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.currencyconverterapp.ApiPackage.ClientClass;
import com.example.currencyconverterapp.ApiPackage.ConnectionApi;
import com.example.currencyconverterapp.Model.CurrencyResponse;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.spinnerfrom) Spinner spinner_from;
    @BindView(R.id.spinner_to) Spinner getSpinner_to;
    @BindView(R.id.convertbtn) Button convertbtn;
    @BindView(R.id.amount) EditText amount;
    @BindView(R.id.errorcode) TextView errorcode;
    @BindView(R.id.progress)  ProgressBar progressBar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        convertbtn.setOnClickListener(this);
        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(this,R.array.country_codes, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_from.setAdapter(arrayAdapter);
        getSpinner_to.setAdapter(arrayAdapter);



    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View view) {
        if (view==convertbtn){
            String from_country_selected=spinner_from.getSelectedItem().toString();
            String to_country_selected=getSpinner_to.getSelectedItem().toString();
            String input_Value=amount.getText().toString();
         if (view==convertbtn) {
            if (from_country_selected.equals("")) {

                Toast.makeText(this, "Select initial Conversion Value", Toast.LENGTH_SHORT).show();
            }else
                if (to_country_selected.equals("")) {
                    Toast.makeText(this, "Select final Conversion Value", Toast.LENGTH_SHORT).show();

            }else
                if (input_Value.equals("")) {
                    Toast.makeText(this, "Amount cannot be blank", Toast.LENGTH_SHORT).show();
            }else {
                    conversionAPI(from_country_selected,to_country_selected,Double.parseDouble(input_Value));
                }
        }

        }
    }
    ConnectionApi connectionApi;

    public  void conversionAPI(String initialCountry,String finalCountry,Double amt){
        connectionApi= ClientClass.getClient();
        Call<CurrencyResponse> call=connectionApi.getCurrencyValue(initialCountry,finalCountry,amt);

        progressBar.setVisibility(View.VISIBLE);
            call.enqueue(new Callback<CurrencyResponse>() {
                @Override
                public void onResponse(Call<CurrencyResponse> call, Response<CurrencyResponse> response) {


                    if (response.isSuccessful()){
                        progressBar.setVisibility(View.GONE);
                        errorcode.setText(response.code());
                    }
                    else {
                        progressBar.setVisibility(View.GONE);
                        errorcode.setText("unable to complete request");
                    }
                }

                @Override
                public void onFailure(Call<CurrencyResponse> call, Throwable t) {
                    errorcode.setText("Something went wrong.Try again later");

                }
            });
        progressBar.setVisibility(View.GONE);



    }
    void sharedPeference(){
        SharedPreferences sharedPreferences= getSharedPreferences("shared preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        Gson gson=new Gson();
//        String json=gson.toJson();
//        editor.putString("task",json);
        editor.apply();
    }
}