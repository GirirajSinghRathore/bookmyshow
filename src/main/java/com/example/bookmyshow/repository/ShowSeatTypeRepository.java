package com.example.bookmyshow.repository;

import com.example.bookmyshow.model.Show;
import com.example.bookmyshow.model.ShowSeatType;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType,Long> {
    @Override
    Optional<ShowSeatType> findById(Long aLong);


    List<ShowSeatType>  findAllByShow(Show show);
}
