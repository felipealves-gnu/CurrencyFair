package com.currencyfair.pojos;

import java.io.Serializable;

/**
 *
 * @author felipe
 */
public class TradeMessage implements Serializable{
    
    private String userId;
    private String currencyFrom;
    private String currencyTo;
    private String amountSell;
    private String amountBy;
    private String rate;
    private String timePlaced;
    private String originatingCountry;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public String getAmountSell() {
        return amountSell;
    }

    public void setAmountSell(String amountSell) {
        this.amountSell = amountSell;
    }

    public String getAmountBy() {
        return amountBy;
    }

    public void setAmountBy(String amountBy) {
        this.amountBy = amountBy;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTimePlaced() {
        return timePlaced;
    }

    public void setTimePlaced(String timePlaced) {
        this.timePlaced = timePlaced;
    }

    public String getOriginatingCountry() {
        return originatingCountry;
    }

    public void setOriginatingCountry(String originatingCountry) {
        this.originatingCountry = originatingCountry;
    }
    
    
}
