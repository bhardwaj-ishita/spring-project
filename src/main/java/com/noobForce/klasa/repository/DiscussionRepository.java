package com.noobForce.klasa.repository;

import com.noobForce.klasa.model.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion,Long> {
    List<Discussion> findByDate(LocalDate date);
}
