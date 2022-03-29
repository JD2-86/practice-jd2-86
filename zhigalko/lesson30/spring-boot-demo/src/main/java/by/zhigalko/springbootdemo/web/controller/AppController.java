package by.zhigalko.springbootdemo.web.controller;

import by.zhigalko.springbootdemo.dal.entity.Message;
import by.zhigalko.springbootdemo.service.MessageService;
import by.zhigalko.springbootdemo.web.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {
    private final MessageService messageService;

    @Autowired
    public AppController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/message/{id}")
    public MessageDto showMessage(@PathVariable("id") Long id) {
        return messageService.convertToDTO(messageService.findById(id));
    }

    @PostMapping (value = "/message", produces = "application/json", consumes="application/json")
    public MessageDto addMessage(@RequestBody MessageDto messageDto) {
        Message message = messageService.save(messageService.convertToEntity(messageDto));
        return messageService.convertToDTO(message);
    }
}
