package com.nataajahtask.restservice.models;

public class AccountResult {

    private String  provider;
    private boolean isValid;

    public AccountResult(String provider, boolean isValid){
        this.provider = provider;
        this.isValid = isValid;
    }

    public String getProvider(){
        return provider;
    }

    public void setProvider(String provider){
        this.provider = provider;
    }

    public boolean getIsValid(){
        return isValid;
    }

    public void setIsValid(boolean isValid){
        this.isValid = isValid;
    }
}
