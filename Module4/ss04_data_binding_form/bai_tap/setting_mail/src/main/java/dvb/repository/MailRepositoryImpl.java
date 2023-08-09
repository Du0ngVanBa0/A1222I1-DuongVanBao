package dvb.repository;

import dvb.model.Mail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MailRepositoryImpl implements IMailRepository {
    private static Map<String, Mail> mailMap;

    static {
        mailMap = new HashMap<>();
        mailMap.put("M001", new Mail("M001", "English", 25, true, "Emilia-tan"));
        mailMap.put("M002", new Mail("M002", "Vietnamese", 25, true, "Hong-kun"));
        mailMap.put("M003", new Mail("M003", "Japanese", 50, false, "Bao-chan"));
        mailMap.put("M004", new Mail("M004", "Chinese", 25, true, "Uzumaki Naruto"));
    }

    @Override
    public List<Mail> findAll() {
        return new ArrayList<>(mailMap.values());
    }

    @Override
    public void update(Mail mail) {
        if (mailMap.containsKey(mail.getMailID())) {
            mailMap.put(mail.getMailID(), mail);
        }
    }

    @Override
    public Mail findByID(String id) {
        return mailMap.get(id);
    }
}
