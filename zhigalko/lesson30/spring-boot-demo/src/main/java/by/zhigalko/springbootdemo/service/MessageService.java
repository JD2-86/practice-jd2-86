package by.zhigalko.springbootdemo.service;

import by.zhigalko.springbootdemo.dal.entity.Message;
import by.zhigalko.springbootdemo.web.dto.MessageDto;

public interface MessageService {
    Message save(Message message);
    Message findById(Long id);
    Message convertToEntity (MessageDto messageDto);
    MessageDto convertToDTO (Message message);
}
