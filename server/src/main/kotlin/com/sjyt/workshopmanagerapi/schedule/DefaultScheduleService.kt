package com.sjyt.workshopmanagerapi.schedule

import com.sjyt.workshopmanagerapi.schedule.entity.Schedule
import org.springframework.stereotype.Service

interface ScheduleService {
    fun getAllSchedules(): List<Schedule>
}

@Service
class DefaultScheduleService(val scheduleRepository: ScheduleRepository): ScheduleService {
    override fun getAllSchedules(): List<Schedule> {
        return scheduleRepository.findAll()
    }
}