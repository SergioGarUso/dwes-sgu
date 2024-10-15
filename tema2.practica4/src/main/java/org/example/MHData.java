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
public class MHData {
    @JsonProperty("id")
    private String id;

    @JsonProperty("nombre")
    private String nombre;

    private String url="https://mhw-db.com/monsters/"+id;
}
