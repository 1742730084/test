package com.test.dao;

import com.test.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    @Select("select * from user where email is not null")
    public List<User> selectAll();

    @Select("select * from user where email=#{email} and password=#{password}")
    public User select(User u);

    @Select("select * from user where email=#{email}")
    public User selectName(String email);

    @Update("update user set image=#{image},name=#{name},signature=#{signature} where id=#{id}")
    public boolean update(User u);

    @Delete("delete from user where id=#{id}")
    public boolean delete(String id);

    @Insert("insert into user (email,password) values(#{email},#{password})")
    public boolean add(User u);

    @Insert("insert into user (name,age,sex,phone,address) values(#{name},#{age},#{sex},#{phone},#{address})")
    public boolean add2(User u);

    @Update("update user set name=#{name},age=#{age},sex=#{sex},phone=#{phone},address=#{address} where id=#{id}")
    public boolean update2(User u);

    @Delete("delete from user where id=#{id}")
    public boolean delete2(String id);

    @Select("select * from user where age is not null")
    public List<User> selectAll2();

    @Select("select * from user where id=#{id}")
    public User selectId(String id);

//    @Select("select * from user where sex IS not NULL and name LIKE '%${name}%' limit ${min},${max}")
    public List<User> selectLike(@Param("name") String name, @Param("min") Integer min, @Param("max") Integer max);

    public List<User> selectLikeAll(@Param("name") String name);
}
