package com.example.springbootredisdemo.service;

import com.example.springbootredisdemo.model.User;

import java.util.List;

/**
 * Created by Liton
 * Date: 26-Mar-2023 5:47 PM
 */

public interface UserService {

    boolean saveUser(User user);

    List<User> fetchAllUser();

    User fetchUserById(Long id);

    boolean deleteUser(Long id);

    boolean updateUser(Long id, User user);
}
