package edu.cyclone.insider.repos;

import edu.cyclone.insider.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID> {
}
