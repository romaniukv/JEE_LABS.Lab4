package labwork3.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORIES")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "category")
    private String categoryName;


    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    private Set<Book> bookList;

    public Category() {

    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String name) {
        this.categoryName = name;
    }


    public Set<Book> getBookList() {
        return bookList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
