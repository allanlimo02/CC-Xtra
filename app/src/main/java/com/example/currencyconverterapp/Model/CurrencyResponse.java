
package com.example.currencyconverterapp.Model;

import java.io.Serializable;
import java.util.List;
//import javax.annotation.Generated;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;

//import com.example.currencyconverterapp.Result;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class CurrencyResponse implements Serializable, Parcelable
{

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("validationMessage")
    @Expose
    private List<Object> validationMessage = null;
    @SerializedName("result")
    @Expose
    private Result result;
    public final static Creator<CurrencyResponse> CREATOR = new Creator<CurrencyResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CurrencyResponse createFromParcel(android.os.Parcel in) {
            return new CurrencyResponse(in);
        }

        public CurrencyResponse[] newArray(int size) {
            return (new CurrencyResponse[size]);
        }

    }
    ;
    private final static long serialVersionUID = 7603151461825288959L;

    protected CurrencyResponse(android.os.Parcel in) {
        this.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.validationMessage, (Object.class.getClassLoader()));
        this.result = ((Result) in.readValue((Result.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public CurrencyResponse() {
    }

    /**
     * 
     * @param result
     * @param success
     * @param validationMessage
     */
    public CurrencyResponse(Boolean success, List<Object> validationMessage, Result result) {
        super();
        this.success = success;
        this.validationMessage = validationMessage;
        this.result = result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public CurrencyResponse withSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public List<Object> getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(List<Object> validationMessage) {
        this.validationMessage = validationMessage;
    }

    public CurrencyResponse withValidationMessage(List<Object> validationMessage) {
        this.validationMessage = validationMessage;
        return this;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public CurrencyResponse withResult(Result result) {
        this.result = result;
        return this;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(success);
        dest.writeList(validationMessage);
        dest.writeValue(result);
    }

    public int describeContents() {
        return  0;
    }

}
