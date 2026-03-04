package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.Book;
import com.example.demo.model.BookDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private final List<BookDTO> books = new ArrayList<>(
		    Arrays.asList(
		        new BookDTO(1, "Clean Code", "Robert C. Martin"),
		        new BookDTO(2, "Effective Java", "Joshua Bloch"),
		        new BookDTO(3, "Design Patterns", "GoF")
		    )
		);

    @GetMapping
    @ResponseBody
    public List<BookDTO> getAllBooks() {
        return books;
    	
    }

    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO addBook(@RequestBody BookDTO newBook) {
        books.add(newBook);
        return newBook;
    }
    
    @GetMapping("/search")
	public List<BookDTO> searchByTitle(@RequestParam String title) {
	    if (title == null || title.isBlank()) {
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "title parameter is required");
	    }
	
	    return books.stream()
	            .filter(b -> b.getTitle() != null &&
	                         b.getTitle().toLowerCase().contains(title.toLowerCase()))
	            .toList(); // If you're on Java 8, use .collect(Collectors.toList())
	}
    

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .map(b -> {
                    books.remove(b);
                    return ResponseEntity.ok("Book with id " + id + " was deleted successfully.");
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Book with id " + id + " not found."));
    }
    
    


}

