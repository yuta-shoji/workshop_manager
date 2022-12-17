package com.sjyt.workshopmanagerapi.schedule

import com.sjyt.workshopmanagerapi.schedule.entity.ScheduleResults
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/schedule")
class ScheduleController(private val scheduleService: ScheduleService) {
    @GetMapping
    fun getAllSchedules(): ScheduleResults {
        return scheduleService.getAllSchedules()
    }
}