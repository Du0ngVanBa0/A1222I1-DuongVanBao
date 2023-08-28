package dvb.song_validate.service;

import dvb.song_validate.entity.Song;
import dvb.song_validate.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongRepository songRepository;

    @Override
    public void create(Song song) {
        songRepository.save(song);
    }

    @Override
    public void update(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findByID(int id) {
        return songRepository.findById(id).orElse(null);
    }
}
