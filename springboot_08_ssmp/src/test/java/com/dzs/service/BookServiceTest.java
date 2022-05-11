package com.dzs.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dzs.dao.BookDao;
import com.dzs.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Test
    void getById(){
        System.out.println(bookService.getById(1));
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setName("test2");
        book.setType("test2");
        book.setDescription("test2");
        bookService.save(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setName("test12");
        book.setType("test1");
        book.setDescription("test1");
        book.setId(3);
        bookService.update(book);
    }
    @Test
    void testDelete(){
        bookService.delete(5);
    }
    @Test
    void testGetAll(){
        System.out.println(bookService.getAll());
    }

    @Test
        //    分页
    void testGetPage(){
        IPage page = bookService.getPage(1,2);
        //        获取总页数
        System.out.println(page.getPages());
//        获取当前页
        System.out.println(page.getCurrent());
//        获取查询的结果
        System.out.println(page.getRecords());
        //        获取查询的结果长度
        System.out.println(page.getSize());
        //        获取全部数据长度
        System.out.println(page.getTotal());
    }

}
