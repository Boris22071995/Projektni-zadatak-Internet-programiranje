package org.unibl.program.Service;

import org.unibl.program.Entity.Contact;
import org.unibl.program.Entity.Requests.ContactRequest;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contact createContact(ContactRequest contactRequest);
    Optional<Contact> getContactById(Integer id);
    List<Contact> getContacts();

    Contact getContactsByName(String name);
    void deleteContact(Integer id);
}
