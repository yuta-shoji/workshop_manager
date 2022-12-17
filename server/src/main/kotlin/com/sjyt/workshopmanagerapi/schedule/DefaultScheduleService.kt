package com.sjyt.workshopmanagerapi.schedule

import com.sjyt.workshopmanagerapi.schedule.entity.ScheduleResults
import org.springframework.stereotype.Service

interface ScheduleService {
    fun getAllSchedules(): ScheduleResults
}

@Service
class DefaultScheduleService(val scheduleRepository: ScheduleRepository): ScheduleService {
    override fun getAllSchedules(): ScheduleResults {
        return ScheduleResults(
            scheduleRepository.count(),
            scheduleRepository.findAll()
        )
    }
}