package com.example.demo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.H2Book;
import com.example.demo.repository.BookRepository;

@Service
public class H2BookService {


	private final BookRepository bookrepository;

    public H2BookService(BookRepository repository) {
        this.bookrepository = repository;
    }

    public List<H2Book> getAll() {
        return bookrepository.findAll();
    }

    public List<H2Book> searchByTitle(String title) {
        // Example derived query in your repository:
        // List<Book> findByTitleContainingIgnoreCase(String title);
        return bookrepository.findByTitleContainingIgnoreCase(title);
    }
    public H2Book create(H2Book book) {
        return bookrepository.save(book);
    }

    public H2Book getById(Long id) {
        return bookrepository.findById(id).orElse(null);
    }
    

    public void deleteById(Long id) {
        if (!bookrepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id " + id + " not found.");
        }
        bookrepository.deleteById(id);
    }
    

    public H2Book update(Long id, H2Book incoming) {
        H2Book existing = bookrepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id " + id + " not found."));

        // Full replace of updatable fields (PUT semantics)
        existing.setTitle(incoming.getTitle());
        existing.setAuthor(incoming.getAuthor());
        
        return bookrepository.save(existing);

    }



}
