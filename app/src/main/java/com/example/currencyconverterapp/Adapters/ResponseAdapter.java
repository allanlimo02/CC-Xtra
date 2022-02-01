package com.example.currencyconverterapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyconverterapp.Model.CurrencyResponse;
import com.example.currencyconverterapp.R;

import java.util.List;

public class ResponseAdapter extends RecyclerView.Adapter<ResponseAdapter.ResponseVH> {

    private List<CurrencyResponse> currencyResponsesList;
    private Context context;

    public ResponseAdapter() {
    }
    public void setData(List<CurrencyResponse> currencyResponsesList) {
        this.currencyResponsesList=currencyResponsesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ResponseVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        return new ResponseAdapter.ResponseVH(LayoutInflater.from(context).inflate(R.layout.response_from_api,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ResponseVH holder, int position) {
        CurrencyResponse currencyResponse=currencyResponsesList.get(position);
        String currencyAmmount=currencyResponse.getKesUsd().toString();
        holder.totalAmount.setText(currencyAmmount);

    }

    @Override
    public int getItemCount() {
        return currencyResponsesList.size();
    }

    public class ResponseVH extends RecyclerView.ViewHolder {

        TextView totalAmount,countryCode;
        public ResponseVH(@NonNull View itemView) {
            super(itemView);
            totalAmount=itemView.findViewById(R.id.newamount);
            countryCode=itemView.findViewById(R.id.countrycode);
        }
    }
}
