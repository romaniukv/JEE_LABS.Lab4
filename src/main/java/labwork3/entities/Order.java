package labwork3.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "order_Book",
            joinColumns = { @JoinColumn(name = "orderId") },
            inverseJoinColumns = { @JoinColumn(name = "bookId") }
    )
    private List<Book> books;

    public Order() {

    }

    public Order(User user, Date date, List<Book> books) {
        this.user = user;
        this.date = date;
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
