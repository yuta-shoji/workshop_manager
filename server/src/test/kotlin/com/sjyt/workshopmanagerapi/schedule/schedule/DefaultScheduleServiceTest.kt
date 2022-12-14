package com.sjyt.workshopmanagerapi.schedule.schedule

import com.sjyt.workshopmanagerapi.schedule.DefaultScheduleService
import com.sjyt.workshopmanagerapi.schedule.ScheduleRepository
import com.sjyt.workshopmanagerapi.schedule.ScheduleService
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
                "halloween workshop",
                listOf(
                    Participant(
                        1,
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