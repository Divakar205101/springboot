package com.api.book.bootrestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entite.Book;

@Service
public class BookService {
    
    @Autowired
     private BookRepository bookRepository;

    // private static List<Book> list =new ArrayList<>();

    // static{
    //     list.add(new Book(12, "ramayanam", "valmiki"));
    //     list.add(new Book(36, "rmikenouse", "srisri"));
    //     list.add(new Book(43, "mahabaram", "vadgavyasudhu"));
    // }

    public List<Book> getAllBooks(){
      List<Book> bookList= (List<Book>) this.bookRepository.findAll();
        return bookList;
    }

    public Book getBookbyId(int id){
        Book book=null;
        try{
           book= this.bookRepository.findById(id);
      //  book=list.stream().filter(e->e.getId()==id).findFirst().get();

        }catch(Exception e){

        }
        return book;
    }

    public Book addBook(Book book){
       // list.add(book);
       Book result=this.bookRepository.save(book);
        return result;
    }

    //delete book
    public void deleteBook(int id){
       // list.stream().filter(book ->book.getId()!=id).collect(Collectors.toList());

       this.bookRepository.deleteById(id);
    }

    //update book
    public void updateBook(Book book, int bookid){
        book.setId(bookid);
        this.bookRepository.save(book);
    }
}
