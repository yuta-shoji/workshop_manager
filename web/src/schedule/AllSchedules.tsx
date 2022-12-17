import {Schedule} from "../model/Schedule";
import React, {useEffect, useState} from "react";
import "./styles/AllSchedules.css"
import ScheduleRepo from "./NetworkScheduleRepo";

export default function AllSchedules(
    {scheduleRepo}: {scheduleRepo: ScheduleRepo}
) {
    const [scheduleResults, setScheduleResults] = useState<Schedule[]>([])

    useEffect(() => {
        void (async () => {
            const response = await scheduleRepo.getAllSchedules()
            setScheduleResults(response.results)
        })()
    }, [])

    return (
        <>
            {/*{scheduleResults.map((schedule, index) => (*/}
            {/*    <div key={index}>*/}
            {/*        {schedule.participants.map(participant => (*/}
            {/*            <>*/}
            {/*                <div>{participant.firstName} {participant.lastName}</div>*/}
            {/*                <div>{participant.age}</div>*/}
            {/*                <div>{participant.parentsFirstName} {participant.parentsLastName}</div>*/}
            {/*            </>*/}
            {/*        ))}*/}
            {/*    </div>*/}
            {/*))}*/}
        </>
    )
}