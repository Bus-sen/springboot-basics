package com.busra.springbootbasics.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotBlank(message = "Kullanıcı adı boş olamaz")
    private String username;
    @Size(min = 5, max = 8, message = "Şifre 5 ile 8 karakter arası olmalıdır")
    private String password;
}
