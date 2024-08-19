package org.unibl.program.Service;

public interface EmailService {
    void sendMessage(String to, String subject, String text);
}
