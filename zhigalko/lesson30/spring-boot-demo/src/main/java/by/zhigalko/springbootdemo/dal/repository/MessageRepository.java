package by.zhigalko.springbootdemo.dal.repository;

import by.zhigalko.springbootdemo.dal.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {}
