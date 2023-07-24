package com.FSBTech.application.repository;


import com.FSBTech.application.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface GameServiceRepository extends JpaRepository<Game, String> {
    @Query(value="select  b.game_id , b.name, b.date_Of_Creation, b.active from Game b where b.name = ?1", nativeQuery = true)
    Game getGameById(String name);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Game b where  b.name = ?1 ; ", nativeQuery = true)
    void deleteByName(String name);
}
