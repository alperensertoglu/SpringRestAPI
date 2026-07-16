package com.alperensertoglu.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @NonNull
    private Integer id;

    private String firstName;
    private String lastName;
}
