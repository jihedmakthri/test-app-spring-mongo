package org.example.devopstestspring.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Student {

    @Id
    private String id;

    private String first_name;

    private String family_name;

    private String email_address;
}

