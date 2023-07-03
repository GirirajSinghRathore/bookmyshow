package com.example.bookmyshow.repository;

import com.example.bookmyshow.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository  extends JpaRepository<Booking,Long> {
    @Override
    Optional<Booking> findById(Long aLong);

    @Override
    <S extends Booking> S save(S entity);
}
