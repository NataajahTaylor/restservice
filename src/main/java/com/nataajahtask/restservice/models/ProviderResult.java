package com.nataajahtask.restservice.models;

public class ProviderResult {
    private boolean isValid;

    public ProviderResult(){}

    public ProviderResult(boolean isValid)
    {
        this.isValid = isValid;
    }
    public boolean getIsValid(){
        return isValid;
    }

    public void setIsValid(boolean isValid){
        this.isValid = isValid;
    }
}
