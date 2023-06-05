package case_study.FuramaResort.repository.interfaces;

import case_study.FuramaResort.model.Contact;

public interface IContactRepository extends IRepository<Contact>{
    void edit();
}
