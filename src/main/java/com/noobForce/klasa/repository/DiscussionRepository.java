package com.noobForce.klasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.noobForce.klasa.model.Discussion;

import java.util.Date;
import java.util.List;

@Repository
public interface DiscussionRepository extends JpaRepository {

    List findAllByDate(Date date);

    @Query("select d from Discussion d where d.date = :date")
    List findAllWithDate(@Param("date") Date date);

}
