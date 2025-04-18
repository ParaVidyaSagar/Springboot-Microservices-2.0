package com.med.builder;

import java.util.List;
import java.util.stream.Collectors;

import com.med.dto.BedDTO;
import com.med.dto.RoomDTO;
import com.med.model.Bed;
import com.med.model.Room;

public class RoomBuilder {
	
	public static RoomDTO buildDTOFromRoom(Room room) {
         RoomDTO roomDTO = RoomDTO.builder()
                .roomNumber(room.getRoomNumber())
                .roomType(room.getRoomType())
                .capacity(room.getCapacity())
                .build();
        if(room.getBeds()!=null) {
        	List<BedDTO> bedsDto = room.getBeds().stream()
                    .map(BedBuilder::buildBedDTOFromBed)
                    .collect(Collectors.toList());
        	roomDTO.setBedsList(bedsDto);
        }
        return roomDTO;
        
    }

    public static Room buildRoomFromDTO(RoomDTO roomDTO) {
        Room room = Room.builder()
                .roomNumber(roomDTO.getRoomNumber())
                .roomType(roomDTO.getRoomType())
                .capacity(roomDTO.getCapacity())
                .build();
        
        if (roomDTO.getBedsList() != null) {
            List<Bed> beds = roomDTO.getBedsList().stream()
            		.map(b -> BedBuilder.buildBedFromDto(b, room))
            		.toList();
            room.setBeds(beds);
        }
        return room;
    }


}
