package dvb.service;

import dvb.model.Mail;
import dvb.repository.IMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailServiceImpl implements IMailService {
    @Autowired
    private IMailRepository mailRepository;

    @Override
    public List<Mail> findAll() {
        return mailRepository.findAll();
    }

    @Override
    public void update(Mail mail) {
        mailRepository.update(mail);
    }

    @Override
    public Mail findByID(String id) {
        return mailRepository.findByID(id);
    }
}
