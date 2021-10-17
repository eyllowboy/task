package com.example.tasl004.repositories;

import com.example.tasl004.entities.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface HouseRepository extends PagingAndSortingRepository<House,Long> {

    @Query("select h from House h where  h.deleted=false")
    Page<House> findAll(Pageable pageable);

    @Query("select h from House h where h.area = :area AND h.amountOfRooms= :amountOfRooms and h.deleted=false ")
    Page<House> findAllbyAreaAmountOfRooms(int area, int amountOfRooms, Pageable pageable);

    @Query("select h from House h where  h.amountOfRooms= :amountOfRooms and h.deleted=false")
    Page<House> findAllbyAmountOfRooms( int amountOfRooms, Pageable pageable);

    @Query("select h from House h where  h.area= :area and h.deleted=false")
    Page<House> findAllbyAmountOfArea( int area, Pageable pageable);



}
