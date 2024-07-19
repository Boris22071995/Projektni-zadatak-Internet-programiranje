package org.unibl.program.Controller;

import io.swagger.models.auth.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.program.Entity.Message;
import org.unibl.program.Entity.Requests.MessageRequest;
import org.unibl.program.Service.MessageService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/message")
public class MessageController {

    MessageService messageService;
    public MessageController(MessageService messageService){this.messageService = messageService;}

    @PostMapping
    public ResponseEntity<Message> createMessage(@Valid @RequestBody MessageRequest messageRequest) {
        Message message = messageService.createMessage(messageRequest);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Message> getAll() {return messageService.getAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable("id") Integer id) {
        Optional<Message> message = messageService.getMessage(id);
        return message.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {messageService.delete(id);}
}
