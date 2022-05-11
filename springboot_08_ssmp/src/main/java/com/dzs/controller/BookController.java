package com.dzs.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dzs.domain.Book;
import com.dzs.regular.R;
import com.dzs.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping
    public R getAll(){
        List<Book> data =  iBookService.list();
        return new R(true,data);
    }

    @PostMapping
    public R saveNew(@RequestBody Book book){
        Boolean flag = iBookService.save(book);
        return new R(flag);
    }

    @PutMapping
    //RequestBody代表参数来源于json数据
    public R updateOne(@RequestBody Book book){
        Boolean flag = iBookService.updateById(book);
        return new R(flag);
    }

    @DeleteMapping("/{id}")
    //http:localhost/books/2  代表删除id为2的; @PathVariable代表参数来源于url
    public R deleteOne(@PathVariable Integer id){
        Boolean flag = iBookService.removeById(id);
        return new R(flag);
    }

    @GetMapping("/{id}")
    public R getOne(@PathVariable Integer id){
        Book data =  iBookService.getById(id);
        return new R(true,data);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        IPage<Book> data = iBookService.getPage(currentPage,pageSize);
        return new R(true,data);
    }
}
