package com.pwgolf.golfStats.model.api;

import com.pwgolf.golfStats.model.impl.PlayedHole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayedHoleRepository extends JpaRepository<PlayedHole, Long> {
    PlayedHole findByHoleNumber(String holeNumber);
}
