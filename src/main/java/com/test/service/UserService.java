package com.test.service;

import com.test.bean.User;

import java.util.List;

public interface UserService {
    public List<User> selectAll();

    public User select(User u);

    public User selectName(String email);

    public boolean update(User u);

    public boolean delete(String id);

    public boolean add(User u);

    public boolean add2(User u);

    public boolean update2(User u);

    public boolean delete2(String id);

    public List<User> selectAll2();

    public User selectId(String id);

    public List<User> selectLike(String name,Integer min,Integer max);

    public List<User> selectLikeAll(String name);
}
