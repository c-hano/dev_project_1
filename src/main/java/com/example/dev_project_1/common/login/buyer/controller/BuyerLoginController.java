package com.example.dev_project_1.common.login.buyer.controller;

import com.example.dev_project_1.common.login.buyer.model.EmailForm;
import com.example.dev_project_1.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class BuyerLoginController {

    private final OrderService orderService;

    @GetMapping("/check")
    public String showEmailInputPage(Model model) {
        model.addAttribute("emailForm", new EmailForm());
        model.addAttribute("error", false);
        return "buyerLogin";
    }

    @PostMapping("/check")
    public String checkEmail(@Valid @ModelAttribute("emailForm") EmailForm emailForm,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // 유효성 검증 실패
            return "buyerLogin";
        }

        String email = emailForm.getEmail();
        boolean emailExists = orderService.isCustomerEmailExists(email);

        if (emailExists) {
            // 이메일이 존재하면 /order/detail로 이동
            return "redirect:/order/detail?email=" + email;
        } else {
            // 이메일이 없으면 에러 메시지와 함께 이메일 입력 페이지를 다시 렌더링
            model.addAttribute("error", true);
            return "buyerLogin";
        }
    }
}
