package dvb.blog_app.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue
    private int id;

    private String head;

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releasedDate;

    @ManyToOne()
    @JoinColumn(name = "categoryId")
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog(int id, String head, String content, Date releasedDate, Category category) {
        this.id = id;
        this.head = head;
        this.content = content;
        this.releasedDate = releasedDate;
        this.category = category;
    }

    public Blog() {
    }
}
