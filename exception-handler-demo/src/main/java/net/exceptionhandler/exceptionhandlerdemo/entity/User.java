package net.exceptionhandler.exceptionhandlerdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_testdb")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "Please enter the name")
    private String firstName;
    @NotNull(message = "Please enter the name")
    private String lastName;
    @Email
    private String email;
    @Min(18)
    @Max(65)
    private Integer age;
    @Pattern(regexp = "^^//@%^@%#")
    @NotNull(message = "Please provide valid mobile number")
    private String phoneNo;

}
