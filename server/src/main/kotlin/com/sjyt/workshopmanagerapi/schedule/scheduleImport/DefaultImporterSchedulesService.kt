package com.sjyt.workshopmanagerapi.schedule.scheduleImport

import com.sjyt.workshopmanagerapi.schedule.ScheduleRepository
import com.sjyt.workshopmanagerapi.schedule.entity.Schedule
import org.springframework.stereotype.Service

interface ImportSchedulesService {
    fun importSchedulesFromJSON(schedules: List<Schedule>)
}

@Service
class DefaultImporterSchedulesService(private val scheduleRepository: ScheduleRepository): ImportSchedulesService {
    override fun importSchedulesFromJSON(schedules: List<Schedule>) {
        scheduleRepository.saveAll(schedules)
    }
}