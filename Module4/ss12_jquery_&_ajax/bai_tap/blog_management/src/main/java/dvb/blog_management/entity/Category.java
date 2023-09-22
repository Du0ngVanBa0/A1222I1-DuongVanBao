package dvb.blog_management.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private int categoryId;

    private String name;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    List<Blog> blogs;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Category(int categoryId, String name, List<Blog> blogs) {
        this.categoryId = categoryId;
        this.name = name;
        this.blogs = blogs;
    }

    public Category() {
    }
}
