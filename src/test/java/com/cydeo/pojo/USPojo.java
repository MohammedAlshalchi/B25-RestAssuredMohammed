package com.cydeo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;


@Data
public class USPojo {

    @JsonProperty("post code")
    private String postCode;
    private String country;

    @JsonProperty("country abbreviation")
    private String countryAbbreviation;
    private List <PlacePojo> places;



}
