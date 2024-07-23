package com.bookshop.book_shop_management.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaveAuthorDTO {
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]+$", message = "only contains simple and capital letters")
    String firstName;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]+$", message = "only contains simple and capital letters")
    String lastName;
    @Email
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid Email Type")
    String email;
    ArrayList contact;
}
