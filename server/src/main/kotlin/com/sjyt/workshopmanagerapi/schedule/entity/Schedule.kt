package com.sjyt.workshopmanagerapi.schedule.entity

import javax.persistence.*

@Entity
@Table(name = "schedule")
data class Schedule(
    @Id
    val title: String,

    @OneToMany(mappedBy = "participatingTitle", cascade = [CascadeType.ALL])
    val participants: List<Participant>
)
