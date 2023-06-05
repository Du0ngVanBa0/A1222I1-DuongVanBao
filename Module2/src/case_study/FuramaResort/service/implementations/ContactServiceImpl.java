package case_study.FuramaResort.service.implementations;

import case_study.FuramaResort.model.Contact;
import case_study.FuramaResort.repository.implementations.ContactRepositoryImpl;
import case_study.FuramaResort.service.interfaces.IContactService;

import java.util.List;

public class ContactServiceImpl implements IContactService {
    ContactRepositoryImpl contactRepository = new ContactRepositoryImpl();

    @Override
    public void edit() {

    }

    @Override
    public void display() {
        List<Contact> contactList = contactRepository.getList();
        System.out.println("--Display Contact List--");
        for (Contact contact: contactList){
            System.out.println(contact);
        }
    }

    @Override
    public void add() {

    }
}
