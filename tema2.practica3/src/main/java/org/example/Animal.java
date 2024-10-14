package org.example;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    @JacksonXmlProperty(localName = "id")
    private String id;

    @JacksonXmlProperty(localName = "nombre")
    private String nombre;

    @JacksonXmlProperty(localName = "especie")
    private String especie;

    @JacksonXmlProperty(localName = "edad")
    private int edad;

    @JacksonXmlProperty(localName = "sexo")
    private String sexo;

    @JacksonXmlProperty(localName = "fechaIngreso")
    private String fechaIngreso;

    @JacksonXmlProperty(localName = "adoptado")
    private boolean adoptado;
}
