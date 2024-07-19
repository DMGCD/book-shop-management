package com.bookshop.book_shop_management.controller;

import com.bookshop.book_shop_management.dto.request.RequestUserSaveDTO;
import com.bookshop.book_shop_management.service.UserService;
import com.bookshop.book_shop_management.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user-controller")
@CrossOrigin
public class UserController {
@Autowired
private UserService userService;
    @PostMapping("/user-registered")
    public ResponseEntity<StandardResponse> userRegister(@RequestBody RequestUserSaveDTO user) {
        String save =userService.userRegister(user);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "Save Successful",
                        save
                ), HttpStatus.OK
        );
    }
}
