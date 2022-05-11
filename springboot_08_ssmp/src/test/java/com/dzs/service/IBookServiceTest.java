package com.dzs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dzs.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IBookServiceTest {
    @Autowired
    private IBookService bookService;
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
        book.setId(6);
        bookService.updateById(book);
    }
    @Test
    void testDelete(){
        bookService.removeById(6);
    }
    @Test
    void testGetAll(){
        System.out.println(bookService.list(null));
    }

    @Test
        //    分页
    void testGetPage(){
        IPage page = new Page(2,4);
        bookService.page(page,null);
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
