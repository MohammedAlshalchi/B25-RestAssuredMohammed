package com.cydeo.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StateCityPojo {

    @JsonProperty("country abbreviation")
    private String countryAbbreviation;
    private List<PlacesPojo> places;
    private String country;


    @JsonProperty("place name")
    private String placeName;



}
