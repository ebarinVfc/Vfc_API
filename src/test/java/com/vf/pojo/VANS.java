package com.vf.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VANS {

    private String firstName;
    private String lastName;

    private String email;
    private String password;

    private String phone;

   private String birthDate;
    private String postalCode;
    private Map<String, Object> source;
    private Map<String, Object> subscriptions;
}

