package dvb.repository;

import dvb.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> findAll();

    void save(Song song);
}
