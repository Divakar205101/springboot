package com.api.book.bootrestbook.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class Author {
      
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorid;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "language")
    private String language;
     
   @OneToOne(mappedBy = "author")
   @JsonBackReference
    private Book book;
    

    public int getAuthorid() {
        return authorid;
    }

    public Author() {
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Author [authorid=" + authorid + ", firstname=" + firstname + ", lastname=" + lastname + ", language="
                + language + "]";
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    


}
