package com.alibou.security.dto;

import com.alibou.security.messages.ErrorMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class PublicationDTO implements ErrorMessages {
    private Long id;
    @NotNull
    @NotBlank
    @Pattern(regexp="^[A-Za-z0-9\\s_]*$",message = characterNotAllow)
    @Size(min = 2, max = 250, message = descriptionLength)
    private String description;
    @NotNull
    @NotBlank(message =  blankError)
    @Pattern(regexp="^[A-Za-z0-9\\s_]*$",message = characterNotAllow)
    @Size(min = 2, max = 150, message = summaryLength)
    private String summary;
    private String image;
}

