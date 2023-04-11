package com.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    
    @NotEmpty
    @Size(min = 4, message = "Username must be minimum 3 characters")
    private String name;
    
    @Email(message = "Email Address is not valid")
    @NotEmpty
    private String email;
    
    @NotEmpty
    @Size(min = 3, max = 10, message = "Must be min 3 chars and max 10 chars")
    private String password;
    
    @NotEmpty
    private String about;
}
