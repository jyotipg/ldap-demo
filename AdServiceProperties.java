package com.example.demo;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
@Configuration
@ConfigurationProperties("adservice")
@ToString
@Getter
@Setter
public class AdServiceProperties {

    private String ldapDn;
    private String ldapPassowrd;
    private String ldapHost;
    private String ldapPort;
    private String ldapQuery;
    private String forUserId;
    private String password;

    private String sdKRuntimeTruststore;
    private String sdKRuntimeTruststorePassword;

    private String datasourceDriverClassName;
    private String datasourceUrl;
    private String datasourceUsername;
    private String datasourcePassword;

    private static String TRUST_STORE;

    private static String TRUST_STORE_PASS;

    private static String KEY_STORE;

    private static String KEY_STORE_PASS;

    @Value("${trustStore}")
    private void setStaticTrustStore(String truststore) {
        TRUST_STORE = truststore;
    }

    @Value("${trustStorePass}")
    private void setStaticTrustStorePass(String truststorePass) {
        TRUST_STORE_PASS = truststorePass;
    }

    @Value("${keyStore}")
    private void setStaticKeyStore(String keystore) {
        KEY_STORE = keystore;
    }

    @Value("${keyStorePass}")
    private void setStatickeyStorePass(String keystorePass) {
        KEY_STORE_PASS = keystorePass;
    }

    public static String getTrustStore() {
        return TRUST_STORE;
    }

    public static String getTrustStorePass() {
        return TRUST_STORE_PASS;
    }

    public static String getKeyStore() {
        return KEY_STORE;
    }

    public static String getKeyStorePass() {
        return KEY_STORE_PASS;
    }

}
