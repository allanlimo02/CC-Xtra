
package com.example.currencyconverterapp.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrencyResponseRetrofit {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("validationMessage")
    @Expose
    private List<Object> validationMessage = null;
    @SerializedName("result")
    @Expose
    private Result result;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CurrencyResponseRetrofit() {
    }

    /**
     * 
     * @param result
     * @param success
     * @param validationMessage
     */
    public CurrencyResponseRetrofit(Boolean success, List<Object> validationMessage, Result result) {
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

    public List<Object> getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(List<Object> validationMessage) {
        this.validationMessage = validationMessage;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
