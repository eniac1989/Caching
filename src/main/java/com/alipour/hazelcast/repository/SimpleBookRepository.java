package com.alipour.hazelcast.repository;

import com.alipour.hazelcast.model.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {


    @Override
    @Cacheable("book")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some Book");
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
