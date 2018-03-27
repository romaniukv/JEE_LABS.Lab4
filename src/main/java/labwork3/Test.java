package labwork3;

import labwork3.dao.DAO;
import labwork3.entities.Book;
import labwork3.entities.Category;
import labwork3.utils.JPAUtils;

public class Test {

    public static void main(String[] args) {
        DAO<Book, Integer> bookDAO = new DAO<>(Book.class);
        Book book = new Book(new DAO<Category, Integer>(Category.class).select(4),"The Picture of Dorian Gray", "Oscar Wilde", 1890,
                500, 250, "Some description", true,  "dorianGray.jpg");
        bookDAO.create(book);
        book.setCategory(new DAO<Category, Integer>(Category.class).select(6));
        bookDAO.update(book);
        JPAUtils.shutdown();


    }
}
