package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Monstruo {
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("id")
    private String id;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("name")
    private String name;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("type")
    private String type;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("species")
    private String species;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("description")
    private String description;

    @Override
    public String toString () {
        return "Monstruo nombre " + name + ", Tipo " + type + ", Especie " + species
                + ", \n Mas sobre el " + description;
    }
}