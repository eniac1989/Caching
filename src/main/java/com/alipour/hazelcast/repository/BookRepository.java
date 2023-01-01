package com.alipour.hazelcast.repository;

import com.alipour.hazelcast.model.Book;

public interface BookRepository {

    Book getByIsbn(String isbn);
}
