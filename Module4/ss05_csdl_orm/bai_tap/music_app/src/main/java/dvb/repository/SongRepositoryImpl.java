package dvb.repository;

import dvb.model.Song;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SongRepositoryImpl implements ISongRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Song> findAll() {
        return entityManager.createQuery("from song s").getResultList();
    }

    @Override
    public void save(Song song) {
        entityManager.persist(song);
    }
}
