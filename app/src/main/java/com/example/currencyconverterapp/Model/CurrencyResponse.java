
package com.example.currencyconverterapp.Model;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class CurrencyResponse {

    @SerializedName("KES_USD")
    @Expose
    private Double kesUsd;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CurrencyResponse() {
    }

    /**
     * 
     * @param kesUsd
     */
    public CurrencyResponse(Double kesUsd) {
        super();
        this.kesUsd = kesUsd;
    }

    public Double getKesUsd() {
        return kesUsd;
    }

    public void setKesUsd(Double kesUsd) {
        this.kesUsd = kesUsd;
    }

}
