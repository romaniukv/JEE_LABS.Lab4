package labwork3.controllers;

import labwork3.dao.DAO;
import labwork3.entities.Book;
import labwork3.entities.Category;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;

@ManagedBean(name = "catalog")
@SessionScoped
public class CatalogController {

    private DAO<Book, Integer> bookDAO = new DAO<>(Book.class);

    private Book book;

    private Category currentCategory;

    private List<Book> books;

    public void editBook() throws IOException {
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

    public Category getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(Category currentCategory) throws IOException {
        this.currentCategory = currentCategory;
        FacesContext.getCurrentInstance().getExternalContext().redirect("catalog.xhtml");
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBooks() {
        books = currentCategory.getBookList();
        return books;
    }

}
