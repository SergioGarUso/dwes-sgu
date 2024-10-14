package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProtectoraDeAnimalesRoot {

    @JsonProperty("protectoraDeAnimales")
    private ProtectoraDeAnimales protectoraDeAnimales;

    public ProtectoraDeAnimalesRoot() {
    }

    public ProtectoraDeAnimales getProtectoraDeAnimales() {
        return protectoraDeAnimales;
    }

    public void setProtectoraDeAnimales(ProtectoraDeAnimales protectoraDeAnimales) {
        this.protectoraDeAnimales = protectoraDeAnimales;
    }
}
