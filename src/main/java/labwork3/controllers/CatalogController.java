package labwork3.controllers;

import labwork3.dao.DAO;
import labwork3.entities.Book;
import labwork3.entities.Category;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "catalog")
@SessionScoped
public class CatalogController {

    private DAO<Book, Integer> bookDAO = new DAO<>(Book.class);
    private Book book;
    private int newCategoryId;



    public void setBooks(List<Book> books) {
        this.books = books;
    }

    private List<Book> books = new ArrayList<>();

    public void showAll() throws IOException {
        books = bookDAO.selectAll();
        FacesContext.getCurrentInstance().getExternalContext().redirect("catalog.xhtml");
    }

    public void editBook() throws IOException {
        //System.out.println(editedCategory);
        //System.out.println(new DAO<Category, Integer>(Category.class).select(editedCategory.getId()));
        book.setCategory(new DAO<Category, Integer>(Category.class).select(newCategoryId));
        bookDAO.update(book);
        book.setCanEdit(false);
        FacesContext.getCurrentInstance().getExternalContext().redirect("catalog.xhtml");
    }

    public void removeBook() throws IOException {
        System.out.println(book);
        books.remove(book);
        bookDAO.deleteByKey(book.getId());
        FacesContext.getCurrentInstance().getExternalContext().redirect("catalog.xhtml");

    }

    public List<Category> getCategories() {
        return new DAO<Category, Integer>(Category.class).selectAll();
    }


    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBooks() {
        return books;
    }





    public void changeCategory(ValueChangeEvent event) {
        newCategoryId = Integer.valueOf(event.getNewValue().toString());
    }


}
