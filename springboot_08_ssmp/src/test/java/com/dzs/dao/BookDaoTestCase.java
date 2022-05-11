package com.dzs.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dzs.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(1));
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setName("test2");
        book.setType("test2");
        book.setDescription("test2");
        bookDao.insert(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setName("test12");
        book.setType("test1");
        book.setDescription("test1");
        book.setId(3);
        bookDao.updateById(book);
    }
    @Test
    void testDelete(){
        bookDao.deleteById(4);
    }
    @Test
    void testGetAll(){
        System.out.println(bookDao.selectList(null));
    }

    @Test
        //    分页
    void testGetPage(){
//        要实现分页需进行mp的配置。在配置类中配置拦截器，config.MpConfig
        IPage page = new Page(1,2);
//        得到的结果会返回到page中
        bookDao.selectPage(page,null);
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

    @Test
        //    按条件查询
    void testGetBy(){
//        创建queryWrapper对象
        QueryWrapper<Book> queryWrapper = new QueryWrapper<Book>();
//        添加条件列和条件值,查询name包含spring的所有数据
        queryWrapper.like("name","spring");
        bookDao.selectList(queryWrapper);
    }

    @Test
        //    按条件查询
    void testGetBy2(){
//        创建lambdaqueryWrapper对象
        String condition = null;
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<Book>();
//        添加条件列和条件值,查询name包含spring的所有数据
        lambdaQueryWrapper.like(condition != null,Book::getName,condition);
        bookDao.selectList(lambdaQueryWrapper);
    }
}
