package com.neuedu.hospital_back.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.neuedu.hospital_back.po.User;
import com.neuedu.hospital_back.mapper.UserMapper;

import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;


    public boolean deleteByPrimaryKey(Integer uId) {
        userMapper.deleteByPrimaryKey(uId);
        return true;
    }


    public boolean insert(User record) {
        userMapper.insert(record);
        return true;
    }


    public boolean updateByPrimaryKeySelective(User record) {

        userMapper.updateByPrimaryKeySelective(record);

        return true;
    }

    public List<User> selectByCondition(User user){
        return userMapper.getUserByCondition(user);
    }

    public List<User> selectAllUser(){
        return userMapper.getAllUser();
    }

}
