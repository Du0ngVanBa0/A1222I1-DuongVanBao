package dvb.song_validate.service;

import dvb.song_validate.entity.Song;

public interface SongService {
    void create(Song song);

    void update(Song song);

    Song findByID(int id);
}
