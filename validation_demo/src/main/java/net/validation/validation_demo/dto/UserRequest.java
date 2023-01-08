package net.validation.validation_demo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class UserRequest {

    @NotNull(message = "username should not be null")
    private String name;
    @Email(message = "Invalid email address")
    private String email;
    @Pattern(regexp = "^\\d{10}$")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;

}
