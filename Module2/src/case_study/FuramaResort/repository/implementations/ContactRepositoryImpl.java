package case_study.FuramaResort.repository.implementations;

import case_study.FuramaResort.model.Contact;
import case_study.FuramaResort.model.ContactComparator;
import case_study.FuramaResort.repository.interfaces.IContactRepository;

import java.util.*;

public class ContactRepositoryImpl implements IContactRepository {
    static Queue<Contact> contactQueue = new LinkedList<>();

    static {
        contactQueue.add(new Contact("CT-1234", "BK-0034", 1000, 2000));
        contactQueue.add(new Contact("CT-1235", "BK-0133", 1000, 2000));
        contactQueue.add(new Contact("CT-1236", "BK-0001", 1000, 2000));
    }

    private void refreshQueue() {
        List<Contact> contactList = new LinkedList<>(contactQueue);
        contactList.sort(new ContactComparator());
        contactQueue = new LinkedList<>(contactList);
    }

    @Override
    public List<Contact> getList() {
        refreshQueue();
        return new ArrayList<>(contactQueue);
    }

    @Override
    public void addNew(Contact obj) {

    }

    @Override
    public void edit() {

    }
}
