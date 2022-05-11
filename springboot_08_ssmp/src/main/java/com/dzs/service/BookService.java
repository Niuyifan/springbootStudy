//传统方法，需手动定义各种常规方法。
package com.dzs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dzs.domain.Book;

import java.util.List;

public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
    IPage<Book> getPage(int currentPage, int pageSize);
}
