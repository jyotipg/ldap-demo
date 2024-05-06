package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DemoComponent {
    @Value("${name}")
    private String name;

    @Autowired
    AdServiceProperties adServiceProperties;



    @PostConstruct
    public void init()
    {
        name= name.toUpperCase().concat(" <br> I  am  from PostConstruct ");
    }
    public String  getName()
    {
        return name;
    }

    public String readPropereties()
    {
        return  adServiceProperties.getLdapDn()+" <br>  "+adServiceProperties.getLdapPassowrd()
                +adServiceProperties.getLdapHost()+" <br> "+adServiceProperties.getLdapPort()
                +adServiceProperties.getLdapQuery()+" <br> "+adServiceProperties.getForUserId()
                +adServiceProperties.getPassword()+" <br> "+adServiceProperties.getSdKRuntimeTruststore()
                +adServiceProperties.getSdKRuntimeTruststorePassword()+" <br> "+adServiceProperties.getDatasourceDriverClassName()
                +adServiceProperties.getDatasourceUrl()+" <br> "+adServiceProperties.getDatasourceUsername()
                +" <br> "+adServiceProperties.getDatasourcePassword();
    }

    public String  readStaticProperties()
    {
        return AdServiceProperties.getKeyStore()+" <br> "+AdServiceProperties.getKeyStorePass()
                +" <br> "+AdServiceProperties.getTrustStore()+" <br>  "+AdServiceProperties.getTrustStorePass();
    }
}
