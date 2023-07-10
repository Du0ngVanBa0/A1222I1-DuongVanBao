package repository.category;

import model.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryRepository implements ICategoryRepository {
    static Map<Integer, Category> categoryMap;

    static {
        categoryMap = new HashMap<>();
        categoryMap.put(1, new Category(1, "Laptop"));
        categoryMap.put(2, new Category(2, "Smartphone"));
        categoryMap.put(3, new Category(3, "Tivi"));
        categoryMap.put(4, new Category(4, "Tablet"));
    }

    @Override
    public void add(Category category) {
        categoryMap.put(category.getId(), category);
    }

    @Override
    public void update(Category category) {
        categoryMap.put(category.getId(), category);
    }

    @Override
    public Category findByID(int id) {
        return categoryMap.get(id);
    }

    @Override
    public List<Category> findAll() {
        return new ArrayList<>(categoryMap.values());
    }

    @Override
    public void delete(Category category) {
        categoryMap.remove(category.getId());
    }
}
