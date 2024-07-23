package com.bookshop.book_shop_management.service.impl;

import com.bookshop.book_shop_management.dto.request.RequestUserSaveDTO;
import com.bookshop.book_shop_management.entity.User;
import com.bookshop.book_shop_management.exception.EmptyDetailsException;
import com.bookshop.book_shop_management.reporsitory.UserRepo;
import com.bookshop.book_shop_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;


    @Override
    public String userRegister(RequestUserSaveDTO user) {
        User userDetails = modelMapper.map(user, User.class);
        if (userDetails != null) {
            userRepo.save(userDetails);
            return "add";
        } else {
            throw new EmptyDetailsException("Need fill all the details");
        }
    }
}
