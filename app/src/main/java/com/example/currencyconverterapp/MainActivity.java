        package com.example.currencyconverterapp;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.DividerItemDecoration;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.content.Context;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.preference.PreferenceManager;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ProgressBar;
        import android.widget.RelativeLayout;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.currencyconverterapp.Adapters.ResponseAdapter;
        import com.example.currencyconverterapp.Adapters.SharedPreferenceAdapter;
        import com.example.currencyconverterapp.ApiPackage.ClientClass;
        import com.example.currencyconverterapp.ApiPackage.PrimaryValues;
        import com.example.currencyconverterapp.Model.CurrencyResponse;
        import com.example.currencyconverterapp.SharedResourcesFiles.PreferenceItems;
        import com.google.gson.Gson;
        import com.google.gson.reflect.TypeToken;

        import java.lang.reflect.Type;
        import java.util.ArrayList;
        import java.util.List;

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
            @BindView(R.id.closebutton) Button closebutton;
            @BindView(R.id.manualpopup) RelativeLayout manualpopup;
            @BindView(R.id.recyclerview_api)  RecyclerView recyclerview_api;
            @BindView(R.id.recent) TextView recent;
            @BindView(R.id.finalcurrency) TextView finalCurrency;

            ResponseAdapter responseAdapter;
            private ArrayList<PreferenceItems> recentSearch;
            PreferenceItems preferenceItems;

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
                closebutton.setOnClickListener(this);
                updatelist();

            }
            @Override
            protected void onStart() {
                super.onStart();
            }

            @Override
            public void onClick(View view) {
                if (view==closebutton){
                    manualpopup.setVisibility(View.GONE);
                    convertbtn.setVisibility(View.VISIBLE);
                }
                if (view==convertbtn){
                    String from_country_selected=spinner_from.getSelectedItem().toString();
                    String to_country_selected=getSpinner_to.getSelectedItem().toString();
                    String input_Value=amount.getText().toString();
                    validation();

                }
            }

            public  void conversionAPI(String initialCountry,String finalCountry,String a3){
                String userInputCountries=initialCountry+"_"+finalCountry;
                String inputValue=amount.getText().toString();
                finalCurrency.setText(finalCountry);

                Call<CurrencyResponse> currencyResponse=ClientClass.getCurrencyValue().getCurrencyValue(userInputCountries,PrimaryValues.apiKey,PrimaryValues.compact);
                currencyResponse.enqueue(new Callback<CurrencyResponse>() {

                    @Override
                    public void onResponse(Call<CurrencyResponse> call, Response<CurrencyResponse> response) {
                        if (response.isSuccessful()){
                            CurrencyResponse currencyResponses=response.body();
                            convertbtn.setText(response.code());
                            recyclerview_api.setAdapter(responseAdapter);

                        }
                    }
                    @Override
                    public void onFailure(Call<CurrencyResponse> call, Throwable t) {
                        manualpopup.setVisibility(View.VISIBLE);
                        convertbtn.setVisibility(View.GONE);
                    }
                });
            }

            void validation(){
                String from_country_selected=spinner_from.getSelectedItem().toString();
                String to_country_selected=getSpinner_to.getSelectedItem().toString();
                String input_Value=amount.getText().toString();

                if (from_country_selected.equals("")) {

                    Toast.makeText(this, "Select initial Conversion Value", Toast.LENGTH_SHORT).show();
                }else
                if (to_country_selected.equals("")) {
                    Toast.makeText(this, "Select final Conversion Value", Toast.LENGTH_SHORT).show();

                }
                else
                if (input_Value.equals("")) {
                    Toast.makeText(this, "Amount cannot be blank", Toast.LENGTH_SHORT).show();
                }else
                if (to_country_selected.equals(from_country_selected)){

                    Toast.makeText(this, "From and to Values cannot be the same", Toast.LENGTH_SHORT).show();
                }else {
                    conversionAPI(from_country_selected,to_country_selected,input_Value);
                    savetoSharedPreference();
                }
            }


        private void savetoSharedPreference(){
                SharedPreferences sharedPreferences=getSharedPreferences("shared preferences",MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                Gson gson=new Gson();
                String json=gson.toJson(recentSearch);
                editor.putString("previous search",json);
                editor.apply();
        }
        private void updatelist(){
            SharedPreferences sharedPreferences=getSharedPreferences("shared preferences",MODE_PRIVATE);
            Gson gson=new Gson();
            String json =sharedPreferences.getString("previous search",null);
            Type type = new TypeToken<ArrayList<PreferenceItems>>() {}.getType();
            recentSearch=gson.fromJson(json,type);

            if (recentSearch==null){
                recentSearch=new ArrayList<>();
            }
        }
        void recviewbuilder(String c1, String c2,String c3){
                preferenceItems=new PreferenceItems(c1,c2,c3);

        }
        void retrofitConversionClass(){


        }
        }