package org.example.firstspringproject.controller;

import org.example.firstspringproject.model.Message;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final List<Message> messages = new ArrayList<>(
            List.of(
                    new Message("1","Domi", "Lets'get it"),
                    new Message("2", "Claude", "Yes siiiiir"),
                    new Message("3", "Laila", "Morgen squashen?")
            ));
    @GetMapping
    public List<Message> getMessages() {

        return messages;
    }

    @PostMapping
    public Message addMessage(@RequestBody Message message) {
       // message.setId(UUID.randomUUID().toString());
        messages.add(message);
        return message;
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable String id) {
        messages.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst().ifPresent(messages::remove);
    }

    @GetMapping("/search")
    public Message getMessageById(@RequestParam String id) {
        return messages.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst().get();
    }

}
