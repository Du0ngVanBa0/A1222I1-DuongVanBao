package dvb.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "song")
public class Song {
    @Id
    private int id;
    private String name;
    private String authorName;
    private String types;
    private String songURL;

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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getSongURL() {
        return songURL;
    }

    public void setSongURL(String songURL) {
        this.songURL = songURL;
    }

    public Song(int id, String name, String authorName, String types, String songURL) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.types = types;
        this.songURL = songURL;
    }

    public Song() {
    }
}
