package org.unibl.program.Service.Implementation;

import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Contact;
import org.unibl.program.Entity.Requests.ContactRequest;
import org.unibl.program.Repository.ContactRepostory;
import org.unibl.program.Service.ContactService;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepostory contactRepostory;

    public ContactServiceImpl(ContactRepostory contactRepostory) {
        this.contactRepostory = contactRepostory;
    }

    @Override
    public Contact createContact(ContactRequest contactRequest) {
        Contact contact = new Contact();
        contact.setIdcontact(contactRequest.getIdcontact());
        contact.setName(contactRequest.getName());
        return contactRepostory.save(contact);
    }

    @Override
    public Optional<Contact> getContactById(Integer id) {
        return contactRepostory.findById(id);
    }

    @Override
    public List<Contact> getContacts() {
        return contactRepostory.findAll();
    }

    @Override
    public Contact getContactsByName(String name) {
        return contactRepostory.getContactByName(name);
    }

    @Override
    public void deleteContact(Integer id) {
    contactRepostory.deleteById(id);
    }
}
