package com.nataajahtask.restservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AccountIncoming {
    @JsonProperty("accountNumber")
    private Long accountNumber;

    @JsonProperty("providers")
    private List<String> providers;

    public Long getAccountNumbers() {
        return accountNumber;
    }

    public void setAccountNumbers(Long accountNumbers) {
        this.accountNumber = accountNumbers;
    }

    public List<String> getProviders() {
            return providers;
    }

    public void setProviders(List<String> providers) {
        this.providers = providers;
    }

}
