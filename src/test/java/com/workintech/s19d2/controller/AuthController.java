package com.workintech.s19d2.controller;


import com.workintech.s19d2.dto.RegisterResponse;
import com.workintech.s19d2.dto.RegistrationMember;
import com.workintech.s19d2.entity.Member;
import com.workintech.s19d2.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegistrationMember registrationMember){
       Member createdMember= authenticationService.register(registrationMember.email(),registrationMember.password());
       return new RegisterResponse(createdMember.getEmail(),"kayıt başarılı bir şekilde gerçekleşti.");
    }
}
