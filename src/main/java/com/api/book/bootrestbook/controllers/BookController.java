package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entite.Book;
import com.api.book.bootrestbook.service.BookService;

@RestController
public class BookController {
    
  @Autowired
   BookService bookService;

   @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
      List<Book> list=bookService.getAllBooks();
      if(list.size()<=0){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      return ResponseEntity.status(HttpStatus.CREATED).body(list);

    }
    
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){
          Book book=bookService.getBookbyId(id);
           if(book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
           }
           return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
      Book b=null;
      try {
       b=this.bookService.addBook(book);
       System.out.println(book);
       return ResponseEntity.of(Optional.of(b));
      } catch (Exception e) {
       e.printStackTrace();
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      } 
    }


     @DeleteMapping("/books/{bookid}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookid") int id){
       try {
        this.bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }
    
     //update book
    @PutMapping("/books/{bookid}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookid") int bookid){
               try {
               this.bookService.updateBook(book, bookid); 
               return ResponseEntity.ok().body(book);
               } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
               }
              
    }

}