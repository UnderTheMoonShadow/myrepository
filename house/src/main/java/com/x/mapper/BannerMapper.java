package com.x.mapper;

import com.x.entity.Banner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BannerMapper {
    List<Banner> findAll();
}
