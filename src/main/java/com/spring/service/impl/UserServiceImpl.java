package com.spring.service.impl;

import com.spring.common.exception.DataNotFoundException;
import com.spring.dao.UserRepository;
import com.spring.model.User;
import com.spring.model.UserAddress;
import com.spring.model.UserExtInfo;
import com.spring.model.UserOrder;
import com.spring.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(Integer id) {
        User user = userRepository.findById(id).get();
//        List<UserAddress> userAddresses = user.getAddressList();
//        System.out.println(userAddresses.size());
        return user;
    }

    @Override
    @Transactional
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public void copy(Integer userId) {
        User user = getById(userId);
        try {
            User newUser = new User();
            org.springframework.beans.BeanUtils.copyProperties(user, newUser);
            newUser.setId(null);
            newUser.setAddressList(new ArrayList<>());
            user.getAddressList().forEach(userAddress -> {
                UserAddress newUserAddress = new UserAddress();
                org.springframework.beans.BeanUtils.copyProperties(userAddress, newUserAddress);
                newUserAddress.setCompositeKey(new UserAddress.CompositeKey().setSeq(0));
                newUserAddress.setUser(newUser);
                newUser.getAddressList().add(newUserAddress);
            });
            newUser.setUserOrders(new ArrayList<>());
            user.getUserOrders().forEach(userOrder -> {
                UserOrder newUserOrder = new UserOrder();
                org.springframework.beans.BeanUtils.copyProperties(userOrder, newUserOrder);
                newUserOrder.setId(null);
                newUserOrder.setUser(newUser);
                newUser.getUserOrders().add(newUserOrder);
            });
            UserExtInfo userExtInfo = new UserExtInfo();
            org.springframework.beans.BeanUtils.copyProperties(user.getUserExtInfo(), userExtInfo);
            if (userExtInfo != null) {
                userExtInfo.setId(null);
                userExtInfo.setUser(newUser);
                newUser.setUserExtInfo(userExtInfo);
            }
            userRepository.save(newUser);
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User create() {
        User user = new User();
        user.setBirthDay(LocalDate.now());
        user.setGender('M');
        user.setName("shark2");
        user.setUserOrders(Arrays.asList(new UserOrder().setUser(user).setCreateDate(LocalDateTime.now()).setOrderName("apple")));
        user.setAddressList(Arrays.asList(new UserAddress().setUser(user).setAddress("shanghai GuTang road").setCompositeKey(new UserAddress.CompositeKey().setSeq(0))));
        user.setUserExtInfo(new UserExtInfo().setUser(user).setIdentifier("44430393"));
        return userRepository.save(user);
    }
}
