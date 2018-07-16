package app.dao;

import app.model.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> getAll();

    Category getById(Long id);
}
