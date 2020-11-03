package com.test.service.impl;

import com.test.bean.User;
import com.test.dao.UserDao;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author admin
 */
@Service("UserSercice")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public List<User> selectAll() {
        return dao.selectAll();
    }

    @Override
    public User select(User u){
        return dao.select(u);
    }

    @Override
    public User selectName(String email){
        return dao.selectName(email);
    }

    @Override
    public boolean update(User u) {
        return dao.update(u);
    }

    @Override
    public boolean delete(String id) {
        return dao.delete(id);
    }

    @Override
    public boolean add(User u) {
        return dao.add(u);
    }

    @Override
    public boolean add2(User u) {
        return dao.add2(u);
    }

    @Override
    public boolean update2(User u) {
        return dao.update2(u);
    }

    @Override
    public boolean delete2(String id) {
        return dao.delete2(id);
    }

    @Override
    public List<User> selectAll2() {
        return dao.selectAll2();
    }

    @Override
    public User selectId(String id) {
        return dao.selectId(id);
    }

    @Override
    public List<User> selectLike(String name,Integer min,Integer max){
        return dao.selectLike(name,min,max);
    }

    @Override
    public List<User> selectLikeAll(String name) {
        return dao.selectLikeAll(name);
    }
}
