package com.calorietracker.component.propertie;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Component
@ConfigurationProperties(prefix = "rsa")
public class RsaProperties {

    private RSAPrivateKey privateKey;

    private RSAPublicKey publicKey;

    public RSAPrivateKey getPrivateKey() {
        return privateKey;
    }

    public RsaProperties setPrivateKey(RSAPrivateKey privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    public RSAPublicKey getPublicKey() {
        return publicKey;
    }

    public RsaProperties setPublicKey(RSAPublicKey publicKey) {
        this.publicKey = publicKey;
        return this;
    }
}
