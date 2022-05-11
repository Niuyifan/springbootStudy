package com.dzs.dao.impl;

import com.dzs.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Override
    public void save() {
        System.out.println("book dao is running");
    }
}
