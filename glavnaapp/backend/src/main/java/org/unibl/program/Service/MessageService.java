package org.unibl.program.Service;

import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Message;
import org.unibl.program.Entity.Requests.MessageRequest;

import java.util.List;
import java.util.Optional;

@Service
public interface MessageService {
    List<Message> getAll();
    Message createMessage(MessageRequest messageRequest);
    Optional<Message> getMessage(Integer id);
    void delete(Integer id);
}
