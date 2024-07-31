package org.example.buysourcecode.controller;


import jakarta.validation.Valid;
import org.example.buysourcecode.dto.User.ChangePasswordUserRequest;
import org.example.buysourcecode.dto.User.SignInUserRequest;
import org.example.buysourcecode.dto.User.SignUpUserRequest;
import org.example.buysourcecode.dto.User.UserReponse;
import org.example.buysourcecode.model.User;
import org.example.buysourcecode.model.UserRole;
import org.example.buysourcecode.model.UserStatus;
import org.example.buysourcecode.service.MailService;
import org.example.buysourcecode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @PostMapping("/signup")
    public ResponseEntity<UserReponse> SignUp(@RequestBody @Valid SignUpUserRequest request) {
        User user = userService.findUserByUsername(request.getUsername());
        if (user != null) {
            return ResponseEntity.badRequest().body(
                    UserReponse.builder().comment("Username already exists").build());
        }
        User user1 = User.builder()
                .mail(request.getMail())
                .username(request.getUsername())
                .password(request.getPassword())
                .role(UserRole.USER)
                .createdAt(LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli())
                .updatedAt(LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli())
                .avatar(null)
                .status(UserStatus.ACTIVE)
                .build();
        userService.createUser(user1);

        mailService.sendWelcomeEmail(user1.getUsername(), request.getMail());

        return ResponseEntity.ok(UserReponse.builder()
                .id(user1.getId())
                .username(user1.getUsername())
                .comment("Success Sign Up")
                .build());
    }

    @PostMapping("/signin")
    public ResponseEntity<UserReponse> SignIn(@RequestBody SignInUserRequest request) {
        User user = userService.findUserByUsername(request.getUsername());
        if (user == null){
            return ResponseEntity.badRequest().body(
                    UserReponse.builder().comment("Username no Sign Up").build()
            );
        }
        if (!user.getPassword().equals(request.getPassword())){
            return ResponseEntity.badRequest().body(
                    UserReponse.builder().comment("Wrong Password").build()
            );
        }
        return ResponseEntity.ok().body(
                UserReponse.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .comment("Success Sign In")
                        .build()
        );
    }

    @PostMapping("/changepassword")
    public ResponseEntity<UserReponse> ChangePassword(@RequestBody @Valid ChangePasswordUserRequest request) {
        User user = userService.findUserByUsername(request.getUsername());
        if (user == null){
            return ResponseEntity.badRequest().body(
                    UserReponse.builder().comment("Username no Sign Up").build()
            );
        }
        user.setPassword(request.getPassword());
        userService.updateUser(user);
        return ResponseEntity.ok().body(
                UserReponse.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .comment("Success Change Password")
                        .build()
        );
    }

}
