package labwork3.controllers;

import labwork3.dao.DAO;
import labwork3.entities.Category;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "catalog")
public class CatalogController {

    public List<Category> getCategories() {
        return new DAO<Category, Integer>().selectAll(Category.class);
    }
}
