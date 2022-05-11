//直接继承mp封装好的Iservice，自动添加多种常见方法。
package com.dzs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dzs.domain.Book;

public interface IBookService extends IService<Book> {
    IPage<Book> getPage(int currentPage, int pageSize);
}
