package com.bookshop.book_shop_management.controller;

import com.bookshop.book_shop_management.advice.Advice;
import com.bookshop.book_shop_management.dto.request.RequestUserSaveDTO;
import com.bookshop.book_shop_management.service.UserService;
import com.bookshop.book_shop_management.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user-controller")
@CrossOrigin
@RequiredArgsConstructor()
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final Advice advice;

    @PostMapping("/user-registered")
    public ResponseEntity<StandardResponse> userRegister(@RequestBody RequestUserSaveDTO user) {
        String save = userService.userRegister(user);
        log.info("User added: ");
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "Save Successful",
                        save
                ), HttpStatus.OK
        );
    }

}
