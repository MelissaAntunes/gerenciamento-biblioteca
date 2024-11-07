package org.teste.biblioteca;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {
    private final IntegerProperty bookId;
    private final StringProperty category;
    private final StringProperty name;
    private final StringProperty author;
    private final IntegerProperty copies;

    public Book(int bookId, String category, String name, String author, int copies) {
        this.bookId = new SimpleIntegerProperty(bookId);
        this.category = new SimpleStringProperty(category);
        this.name = new SimpleStringProperty(name);
        this.author = new SimpleStringProperty(author);
        this.copies = new SimpleIntegerProperty(copies);
    }

    public int getBookId() {
        return bookId.get();
    }

    public void setBookId(int bookId) {
        this.bookId.set(bookId);
    }
    public IntegerProperty bookIdProperty() {
        return bookId;
    }
    public String getCategory() {
        return category.get();
    }
    public void setCategory(String category) {
        this.category.set(category);
    }
    public StringProperty categoryProperty() {
        return category;
    }
    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public StringProperty nameProperty() {
        return name;
    }
    public String getAuthor() {
        return author.get();
    }
    public void setAuthor(String author) {
        this.author.set(author);
    }
    public StringProperty authorProperty() {
        return author;
    }
    public int getCopies() {
        return copies.get();
    }
    public void setCopies(int copies) {
        this.copies.set(copies);
    }
    public IntegerProperty copiesProperty() {
        return copies;
    }


}
