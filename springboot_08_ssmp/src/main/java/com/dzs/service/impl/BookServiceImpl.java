//实现IService，并继承mp的ServiceImpl自动实现Iservice定义的各种方法。
package com.dzs.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dzs.dao.BookDao;
import com.dzs.domain.Book;
import com.dzs.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//继承ServiceImpl，传入两个泛型，数据接口和对应的实体类
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page<>(currentPage, pageSize);
        bookDao.selectPage(page,null);
        return  page;
    }
}