package dvb.repository;

import dvb.model.Mail;

import java.util.List;

public interface IMailRepository {
    public List<Mail> findAll();

    public void update(Mail mail);

    public Mail findByID(String id);
}
