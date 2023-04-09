package com.example.springbootredisdemo.repository;

import com.example.springbootredisdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Liton
 * Date: 26-Mar-2023 5:48 PM
 * This is for test
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "USER";

    @Override
    public boolean saveUser(User user) {

        try {
            redisTemplate.opsForHash().put(KEY, user.getId().toString(), user);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public List<User> fetchAllUser() {
        return redisTemplate.opsForHash().values(KEY);
    }

    @Override
    public User fetchUserById(Long id) {
        return (User) redisTemplate.opsForHash().get(KEY, id.toString());
    }

    @Override
    public boolean deleteUser(Long id) {
        try {
            redisTemplate.opsForHash().delete(KEY, id.toString());
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(Long id, User user) {
        try {
            redisTemplate.opsForHash().put(KEY, id.toString(), user);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
