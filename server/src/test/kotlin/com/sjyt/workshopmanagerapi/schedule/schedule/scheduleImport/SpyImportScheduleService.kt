package com.sjyt.workshopmanagerapi.schedule.schedule.scheduleImport

import com.sjyt.workshopmanagerapi.schedule.entity.Schedule
import com.sjyt.workshopmanagerapi.schedule.scheduleImport.ImportSchedulesService

class SpyImportScheduleService: ImportSchedulesService {
    var importSchedulesFromJSON_argument: List<Schedule> = emptyList()
    override fun importSchedulesFromJSON(schedules: List<Schedule>) {
        importSchedulesFromJSON_argument = schedules
    }

}
