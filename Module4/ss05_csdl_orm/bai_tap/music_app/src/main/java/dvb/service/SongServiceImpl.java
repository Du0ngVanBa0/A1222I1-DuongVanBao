package dvb.service;

import dvb.model.Song;
import dvb.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements ISongService {
    @Autowired
    private ISongRepository repository;
    private List<Song> songs = new ArrayList<>();

    @Override
    public List<Song> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Song song) {
        repository.save(song);
    }
}
