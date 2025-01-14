package com.example.dev_project_1.common.login.seller.model;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PasswordForm {
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
}
