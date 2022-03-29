package by.zhigalko.springbootdemo.service;

import by.zhigalko.springbootdemo.dal.entity.Message;
import by.zhigalko.springbootdemo.dal.repository.MessageRepository;
import by.zhigalko.springbootdemo.web.dto.MessageDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, ModelMapper modelMapper) {
        this.messageRepository = messageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message findById(Long id) {
        return messageRepository.findById(id).orElseThrow();
    }

    public Message convertToEntity (MessageDto messageDto) {
        return modelMapper.map(messageDto, Message.class);
    }

    public MessageDto convertToDTO (Message message) {
        return modelMapper.map(message, MessageDto.class);
    }
}
