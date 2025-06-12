package com.nirwantech.com.elk_stack_logging_example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class UserDetails {
    private int id;
    private String name;
}
