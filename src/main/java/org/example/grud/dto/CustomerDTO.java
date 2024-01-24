package org.example.grud.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Long id;

    @NotBlank(message = "Full name cannot be blank")
    @Size(min = 2, max = 50, message = "Full name must be between 2 and 50 characters")
    private String fullName;


    @Email(message = "Email is not valid")
    @NotBlank(message = "Email cannot be blank")
    @Size(max = 100, message = "Email cannot be longer than 100 characters")
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email is not valid")
    private String email;

    @NotBlank (message = "Phone cannot be blank")
    @Pattern(regexp = "^\\+[0-9]{6,10}$", message = "Phone number must start with '+' and contain between 6 and 10 digits")
    private String phone;

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
