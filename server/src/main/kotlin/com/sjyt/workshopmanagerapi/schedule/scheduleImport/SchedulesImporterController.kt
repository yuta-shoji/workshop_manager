package com.sjyt.workshopmanagerapi.schedule.scheduleImport

import com.sjyt.workshopmanagerapi.schedule.entity.Schedule
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/schedule")
class SchedulesImporterController(private val importSchedulesService: ImportSchedulesService) {
    @PostMapping("/import")
    @ResponseStatus(value = CREATED)
    fun postImportSchedules(@RequestBody schedules: List<Schedule>) {
        return importSchedulesService.importSchedulesFromJSON(schedules)
    }
}