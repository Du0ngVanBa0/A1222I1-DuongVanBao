package dvb.service;

import dvb.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongServiceImpl implements ISongService {
    private List<Song> songs = new ArrayList<>();

    @Override
    public List<Song> findAll() {
        return songs;
    }

    @Override
    public void save(Song song) {
        songs.add(song);
    }
}
