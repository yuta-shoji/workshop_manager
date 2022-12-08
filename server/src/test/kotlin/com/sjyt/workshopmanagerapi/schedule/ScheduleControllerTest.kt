package com.sjyt.workshopmanagerapi.schedule

import com.sjyt.workshopmanagerapi.schedule.entity.Participant
import com.sjyt.workshopmanagerapi.schedule.entity.Schedule
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

class ScheduleControllerTest {
    private val stubScheduleService = StubScheduleService()

    @Test
    fun `return all workshop schedules`() {
        stubScheduleService.getAllSchedules_returnValue = listOf(
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

        standaloneSetup(ScheduleController(stubScheduleService))
            .build()
            .perform(get("/api/schedule"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].title", equalTo("halloween workshop")))
            .andExpect(jsonPath("$[0].participants[0].participatingTitle", equalTo("halloween workshop")))
            .andExpect(jsonPath("$[0].participants[0].firstName", equalTo("taro")))
            .andExpect(jsonPath("$[0].participants[0].lastName", equalTo("yamada")))
            .andExpect(jsonPath("$[0].participants[0].age", equalTo(10)))
            .andExpect(jsonPath("$[0].participants[0].parentsFirstName", equalTo("jiro")))
            .andExpect(jsonPath("$[0].participants[0].parentsLastName", equalTo("yamada")))
    }
}
