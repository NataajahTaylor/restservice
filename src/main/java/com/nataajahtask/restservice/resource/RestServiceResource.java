package com.nataajahtask.restservice.resource;

import com.nataajahtask.restservice.models.AccountResult;
import com.nataajahtask.restservice.models.AccountIncoming;
import com.nataajahtask.restservice.models.ProviderIncoming;
import com.nataajahtask.restservice.models.ProviderResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;

@RestController
@RequestMapping("/restservice")
public class RestServiceResource {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${task.providers.name}")
    private List<String> name = new ArrayList<>();

    @Value("${task.providers.url}")
    private List<String> url = new ArrayList<>();

    @RequestMapping("/request")
    public @ResponseBody Map<String,List<AccountResult>> requestResults(@RequestBody AccountIncoming accountIncoming) {

        ProviderIncoming providerIncoming = new ProviderIncoming();
        providerIncoming.setAccountNum(accountIncoming.getAccountNumbers());

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        List<AccountResult> list = new ArrayList<>();
        Map<String,List<AccountResult>> lists = new HashMap<String,List<AccountResult>>();

        if(accountIncoming.getProviders().size() == 0)
        {
            accountIncoming.setProviders(name);
        }
        for (int i = 0; i < accountIncoming.getProviders().size(); i++) {


            HttpEntity<ProviderIncoming> entity = new HttpEntity<>(providerIncoming);

            ResponseEntity<ProviderResult> response = restTemplate.postForEntity(url.get(i),
                    entity,ProviderResult.class);

            list.add(i, new AccountResult(accountIncoming.getProviders().get(i), response.getBody().getIsValid()));
            lists.put("result", list);
        }

        return lists;
    }


}
