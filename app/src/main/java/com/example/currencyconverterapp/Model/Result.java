
package com.example.currencyconverterapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("amountToConvert")
    @Expose
    private Integer amountToConvert;
    @SerializedName("convertedAmount")
    @Expose
    private Double convertedAmount;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param convertedAmount
     * @param amountToConvert
     * @param from
     * @param to
     */
    public Result(String from, String to, Integer amountToConvert, Double convertedAmount) {
        super();
        this.from = from;
        this.to = to;
        this.amountToConvert = amountToConvert;
        this.convertedAmount = convertedAmount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Integer getAmountToConvert() {
        return amountToConvert;
    }

    public void setAmountToConvert(Integer amountToConvert) {
        this.amountToConvert = amountToConvert;
    }

    public Double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(Double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

}
