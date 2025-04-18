package com.med.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.med.model.Room;

public interface RoomRepository extends JpaRepository<Room, String>{

}
