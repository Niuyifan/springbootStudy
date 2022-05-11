package com.dzs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dzs.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao extends BaseMapper<Book> {

}

//@Mapper
//public interface BookDao{
//
//    @Select("select * from tbl_book where id=#{id}")
//    Book getById(Integer id);
//}
