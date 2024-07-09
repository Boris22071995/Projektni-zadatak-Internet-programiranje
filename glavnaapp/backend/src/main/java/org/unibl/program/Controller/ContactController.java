package org.unibl.program.Controller;

import com.fasterxml.jackson.annotation.OptBoolean;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.program.Entity.Contact;
import org.unibl.program.Entity.Requests.ContactRequest;
import org.unibl.program.Service.ContactService;

import java.util.Optional;
import java.util.function.Consumer;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    public void getUserById(@RequestBody ContactRequest id) {
//       Optional<Contact> c = contactService.getContactById(id);
//       Contact cc = null;
//       if(c.isPresent()) {
//            cc = c.get();
//        }
//       Contact c2 = new Contact();
//       c2.setName("bb");

       contactService.createContact(id);

//       return cc;

    }
}
