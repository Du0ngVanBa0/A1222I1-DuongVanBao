package dvb.furama.repository.contract;

import dvb.furama.entity.contact.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
}
