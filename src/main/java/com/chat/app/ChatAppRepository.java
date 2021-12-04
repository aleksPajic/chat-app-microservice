package com.chat.app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatAppRepository extends CrudRepository<ChatMessage, Long> {
}
