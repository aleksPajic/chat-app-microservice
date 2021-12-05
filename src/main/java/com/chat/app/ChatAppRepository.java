package com.chat.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatAppRepository extends JpaRepository<ChatMessage, Long> {
}
