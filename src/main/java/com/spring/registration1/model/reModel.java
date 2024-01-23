package com.spring.registration1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class reModel {
    private String fname;
    private String lname;
    private String email;
    private String password;
}
