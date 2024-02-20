package com.fastDev4j.system.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fastDev4j.system.web.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper  extends BaseMapper<User> {
}
