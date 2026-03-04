package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.BookDTO;
import com.example.demo.model.H2Book;
import com.example.demo.service.H2BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/H2/api/books")
public class H2BookController {

	private final H2BookService service;
    
    public H2BookController(H2BookService service) {
    	this.service = service;
    }
    
    //Post /api/books
    @PostMapping
    public ResponseEntity<H2Book> create(@Valid @RequestBody H2Book book){
    	return ResponseEntity.status(HttpStatus.CREATED).body(service.create(book));
    }
    
    //Get /api/books
    @GetMapping
    public ResponseEntity<List<H2Book>> getAll(@RequestParam(required = false) String title){
    	List<H2Book> book = (title != null)
    			? service.searchByTitle(title)
    			: service.getAll();
    	return ResponseEntity.ok(book);
    	
    }
    


    //GET /H2/api/books/search?title=sample
    @GetMapping("/search")
    public ResponseEntity<List<H2Book>> searchByTitle(@RequestParam String title) {
        return ResponseEntity.ok(service.searchByTitle(title));
    }

    // GET /H2/api/books/{id}
    @GetMapping("/{id}")
    public ResponseEntity<H2Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id)); // throws 404 if missing
    }

    // DELETE /H2/api/books/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteById(id); // throws 404 if missing
        return ResponseEntity.ok("Book with id " + id + " was deleted successfully.");
    }
    
    // PUT /H2/api/books/{id}
    @PutMapping("/{id}")
    public ResponseEntity<H2Book> update(@PathVariable Long id, @Valid @RequestBody H2Book book) {
        H2Book updated = service.update(id, book);
        return ResponseEntity.ok(updated);
    }


}
