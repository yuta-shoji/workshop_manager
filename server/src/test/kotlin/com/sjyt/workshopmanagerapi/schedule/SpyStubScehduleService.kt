package com.sjyt.workshopmanagerapi.schedule

import com.sjyt.workshopmanagerapi.schedule.entity.Schedule

class StubScheduleService: ScheduleService {
    var getAllSchedules_returnValue: List<Schedule> = emptyList()

    override fun getAllSchedules(): List<Schedule> {
        return getAllSchedules_returnValue
    }
}