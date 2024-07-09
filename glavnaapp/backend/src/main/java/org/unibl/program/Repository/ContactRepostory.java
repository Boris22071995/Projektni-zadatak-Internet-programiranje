package org.unibl.program.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unibl.program.Entity.Contact;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepostory extends JpaRepository<Contact, Integer> {
    Optional<Contact> findById(Integer id);
    List<Contact> findAll();

    Contact getContactByName(String name);
    Contact save(Contact contact);
    void deleteById(Integer id);
}
