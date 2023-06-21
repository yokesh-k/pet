package com.itvedant.petstore.dtos;

import java.time.LocalDate;

import com.itvedant.petstore.validators.Mobile;
import com.itvedant.petstore.validators.VerifyPassword;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@VerifyPassword(field = "password", 
                matchingField = "confirmPassword")
public class RegisterUserDto {
    @NotNull @NotEmpty
    @Size(min = 4, max = 10, 
    message = "first name should have the length between 4 and 10")
    private String firstName;
    @NotNull @NotEmpty
    private String lastName;
    @NotNull @NotEmpty(message="email cannot be empty")
    @Email
    private String email;
    @NotNull @NotEmpty(message = "Password cannot be empty")
    private String password;
    @NotNull @NotEmpty
    private String confirmPassword;
    @NotNull @NotEmpty

    @Mobile
    private String mobile;

    @Min(value = 10000, message = "Minimum Salary should be 10000")
    @Max(value = 50000, message = "Maximum Salary should be 50000")
    private Long salary;

    //@Past
    //@PastOrPresent
    //@Future
    //@FutureOrPresent
    private LocalDate joinDate;
}
