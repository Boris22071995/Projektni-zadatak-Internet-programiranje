package org.unibl.program.Service.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Message;
import org.unibl.program.Entity.Requests.MessageRequest;
import org.unibl.program.Repository.MessageRepository;
import org.unibl.program.Service.MessageService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {
    @Autowired
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {this.messageRepository = messageRepository;}

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message createMessage(MessageRequest messageRequest) {
        Message message = Message.builder().idMessage(messageRequest.getIdMessage()).textMessage(messageRequest.getTextMessage()).dateAndTime(messageRequest.getDateAndTime()).isRead(messageRequest.isRead()).reciver(messageRequest.getReciver()).useridUser(messageRequest.getUseridUser()).build();
        Message saved = messageRepository.save(message);
        return saved;
    }

    @Override
    public Optional<Message> getMessage(Integer id) {
        log.info("Getting message with id: " + id);
        return messageRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        messageRepository.deleteById(id);
    }
}
