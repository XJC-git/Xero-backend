package com.xerotech.funcx.service.impl;

import com.xerotech.funcx.entity.User;
import com.xerotech.funcx.mapper.UserMapper;
import com.xerotech.funcx.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ç”¨æˆ·è¡¨ 服务实现类
 * </p>
 *
 * @author XJC-git
 * @since 2023-02-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
