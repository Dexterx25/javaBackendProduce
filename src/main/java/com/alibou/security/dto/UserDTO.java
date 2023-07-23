package com.alibou.security.dto;

import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Builder
public class UserDTO {
    private Integer id;
    private String firstname;
    private String lastname;
    @Email
    private String email;
    private String password;
}
