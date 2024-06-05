package com.piikii.output.persistence.postgresql.adapter.room

import com.piikii.application.domain.model.room.Room
import com.piikii.application.port.output.persistence.RoomCommandPort
import com.piikii.output.persistence.postgresql.persistence.repository.RoomRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class RoomCommandAdapter(
    private val roomRepository: RoomRepository
) : RoomCommandPort {

    override fun save(room: Room): Room {
        TODO("Not yet implemented")
    }

    override fun update(room: Room, id: Long) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}
