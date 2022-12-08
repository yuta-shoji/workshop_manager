package com.sjyt.workshopmanagerapi.schedule

import com.sjyt.workshopmanagerapi.schedule.entity.Participant
import com.sjyt.workshopmanagerapi.schedule.entity.Schedule
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DefaultScheduleServiceTest {
    private lateinit var scheduleService: ScheduleService

    @Autowired
    private lateinit var scheduleRepository: ScheduleRepository

    @BeforeEach
    fun serUp() {
        scheduleService = DefaultScheduleService(scheduleRepository)
    }

    @Test
    fun `return Let's Workshop!!` () {
        val expectedSchedules = listOf(
            Schedule(
                0,
                "halloween workshop",
                listOf(
                    Participant(
                        0,
                        "halloween workshop",
                        "taro",
                        "yamada",
                        10,
                        "jiro",
                        "yamada",
                    )
                )
            )
        )
        scheduleRepository.saveAll(expectedSchedules)


        val actualSchedules = scheduleRepository.findAll()


        assertEquals(expectedSchedules, actualSchedules)
    }
}