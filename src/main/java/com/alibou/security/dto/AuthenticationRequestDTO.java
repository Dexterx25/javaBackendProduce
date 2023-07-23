package com.alibou.security.dto;

import lombok.*;

@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class AuthenticationRequestDTO {
    private String email;
    private String password;
}
