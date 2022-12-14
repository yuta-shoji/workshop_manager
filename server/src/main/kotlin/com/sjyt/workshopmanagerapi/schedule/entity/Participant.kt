package com.sjyt.workshopmanagerapi.schedule.entity

import javax.persistence.*


@Entity
@Table(name = "participant")
data class Participant(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @JoinColumn(name = "title")
    val participatingTitle: String,

    val firstName: String ,
    val lastName: String ,
    val age: Int,
    val parentsFirstName: String ,
    val parentsLastName: String ,
): java.io.Serializable
