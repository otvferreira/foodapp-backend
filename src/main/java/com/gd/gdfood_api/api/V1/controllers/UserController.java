package com.gd.gdfood_api.api.V1.controllers;

import com.gd.gdfood_api.api.V1.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/V1/user/")
public class UserController {

    private UserService userService;

}
