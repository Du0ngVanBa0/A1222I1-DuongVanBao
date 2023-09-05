package dvb.book_rent.repository;

import dvb.book_rent.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent,String> {
}
