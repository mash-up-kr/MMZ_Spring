package com.piikii.output.persistence.postgresql.persistence.entity

import com.piikii.application.domain.vote.Vote
import com.piikii.application.domain.vote.VoteResult
import com.piikii.output.persistence.postgresql.persistence.common.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.SQLRestriction
import java.util.UUID

@Entity
@Table(name = "vote", schema = "piikii")
@SQLRestriction("is_deleted = false")
@DynamicUpdate
class VoteEntity(
    @Column(name = "user_id", nullable = false)
    val userId: UUID,
    @Column(name = "room_place_id", nullable = false)
    val roomPlaceId: Long,
    @Enumerated(EnumType.STRING)
    @Column(name = "result", nullable = false, length = 10)
    val result: VoteResult,
) : BaseEntity() {

    fun toDomain(): Vote {
        return Vote(
            userId = this.userId,
            roomPlaceId = this.roomPlaceId,
            result = this.result,
        )
    }

    companion object {
        fun from(vote: Vote): VoteEntity {
            return VoteEntity(
                userId = vote.userId,
                roomPlaceId = vote.roomPlaceId,
                result = vote.result,
            )
        }
    }

}