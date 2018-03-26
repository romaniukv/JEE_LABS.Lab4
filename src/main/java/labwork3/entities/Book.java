package labwork3.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "BOOKS")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    private String name;

    private String author;

    private int year;

    private int numOfPages;

    private float price;

    private String description;

    private boolean available;

    private String image;

    @ManyToMany(mappedBy = "books")
    private Set<Order> orders;

    @Transient
    private Boolean canEdit;

    public Book() {

    }

    public Book(Category category, String name, String author, int year, int numOfPages,
                float price, String description, boolean available, String image) {
        this.category = category;
        this.name = name;
        this.author = author;
        this.year = year;
        this.numOfPages = numOfPages;
        this.price = price;
        this.description = description;
        this.available = available;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Boolean getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id == book.id && year == book.year &&
                numOfPages == book.numOfPages && Float.compare(book.price, price) == 0 &&
                available == book.available && name.equals(book.name) &&
                author.equals(book.author) && description.equals(book.description) &&
                image.equals(book.image);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", numOfPages=" + numOfPages +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", availability=" + available +
                ", image='" + image + '\'' +
                '}';
    }

//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + categoryId;
//        result = 31 * result + name.hashCode();
//        result = 31 * result + author.hashCode();
//        result = 31 * result + year;
//        result = 31 * result + numOfPages;
//        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
//        result = 31 * result + description.hashCode();
//        result = 31 * result + (availability ? 1 : 0);
//        result = 31 * result + image.hashCode();
//        return result;
//    }
}
