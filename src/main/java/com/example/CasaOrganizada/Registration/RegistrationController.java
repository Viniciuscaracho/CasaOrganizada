package com.example.CasaOrganizada.Registration;

import com.example.CasaOrganizada.Users.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ap1/v1/register")
public class RegistrationController {
    private RegistrationService registrationService;

    public void RegisterUser(@RequestBody RegistrationRequest request) {
        registrationService.register(request);
    }
}
