package com.sjyt.workshopmanagerapi.schedule

import com.sjyt.workshopmanagerapi.schedule.entity.Schedule
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
interface ScheduleRepository: JpaRepository<Schedule, String> {
}