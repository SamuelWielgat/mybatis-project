package com.example.mybatis.service;

import com.example.mybatis.domain.User;
import com.example.mybatis.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
//Ensures database operations are atomic (all-or-nothing), if an error occurs, all changes are rolled back
@Transactional
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User createUser(User user) {
        userMapper.insert(user);
        return user;
    }

    @Override
    //readOnly = true optimizes read operations
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }

    @Override
    public User updateUser(User user) {
        userMapper.update(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userMapper.delete(id);
    }
} 