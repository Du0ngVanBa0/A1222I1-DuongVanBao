package dvb.furama.service.contract;

import dvb.furama.entity.contact.Contract;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();

    void save(Contract contract);
}
