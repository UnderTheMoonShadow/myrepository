package com.x.entity.mapper;

import com.x.entity.domain.TComment;

/**
* @author zxton
* @description 针对表【t_comment】的数据库操作Mapper
* @createDate 2022-06-28 19:26:47
* @Entity com.x.entity.domain.TComment
*/
public interface TCommentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TComment record);

    int insertSelective(TComment record);

    TComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TComment record);

    int updateByPrimaryKey(TComment record);

}
