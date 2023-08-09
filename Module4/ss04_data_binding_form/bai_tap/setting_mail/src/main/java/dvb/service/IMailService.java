package dvb.service;

import dvb.model.Mail;

import java.util.List;

public interface IMailService {
    public List<Mail> findAll();

    public void update(Mail mail);

    public Mail findByID(String id);
}
