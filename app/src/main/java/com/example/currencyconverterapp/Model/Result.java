
package com.example.currencyconverterapp.Model;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Result implements Serializable, Parcelable
{

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
    public final static Creator<Result> CREATOR = new Creator<Result>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Result createFromParcel(android.os.Parcel in) {
            return new Result(in);
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    }
    ;
    private final static long serialVersionUID = -542243019345801405L;

    protected Result(android.os.Parcel in) {
        this.from = ((String) in.readValue((String.class.getClassLoader())));
        this.to = ((String) in.readValue((String.class.getClassLoader())));
        this.amountToConvert = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.convertedAmount = ((Double) in.readValue((Double.class.getClassLoader())));
    }

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

    public Result withFrom(String from) {
        this.from = from;
        return this;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Result withTo(String to) {
        this.to = to;
        return this;
    }

    public Integer getAmountToConvert() {
        return amountToConvert;
    }

    public void setAmountToConvert(Integer amountToConvert) {
        this.amountToConvert = amountToConvert;
    }

    public Result withAmountToConvert(Integer amountToConvert) {
        this.amountToConvert = amountToConvert;
        return this;
    }

    public Double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(Double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public Result withConvertedAmount(Double convertedAmount) {
        this.convertedAmount = convertedAmount;
        return this;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(from);
        dest.writeValue(to);
        dest.writeValue(amountToConvert);
        dest.writeValue(convertedAmount);
    }

    public int describeContents() {
        return  0;
    }

}
