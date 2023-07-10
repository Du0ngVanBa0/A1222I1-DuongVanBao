package service.category;

import model.Category;
import repository.category.CategoryRepository;
import repository.category.ICategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService {
    private CategoryRepository repository = new CategoryRepository();

    @Override
    public Category findById(int id) {
        return repository.findByID(id);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(Category category) {
        repository.add(category);
    }

    @Override
    public void delete(Category category) {
        repository.delete(category);
    }

    @Override
    public void update(Category category) {
        repository.update(category);
    }
}
