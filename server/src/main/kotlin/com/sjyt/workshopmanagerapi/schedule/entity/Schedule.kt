package com.sjyt.workshopmanagerapi.schedule.entity

import jakarta.persistence.*

@Entity
@Table(name = "schedule")
data class Schedule(
    @Id
    val id: Int,

    val title: String,

    @OneToMany(mappedBy = "participatingTitle", cascade = [CascadeType.ALL])
    val participants: List<Participant>
)
