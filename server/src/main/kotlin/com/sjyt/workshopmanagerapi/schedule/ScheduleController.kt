package com.sjyt.workshopmanagerapi.schedule

import com.sjyt.workshopmanagerapi.schedule.entity.Schedule
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/schedule")
class ScheduleController(private val scheduleService: ScheduleService) {
    @GetMapping
    fun getAllSchedules(): List<Schedule> {
        return scheduleService.getAllSchedules()
    }
}