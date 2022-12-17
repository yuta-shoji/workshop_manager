import React from 'react';
import './App.css';
import ScheduleRepo from "./schedule/NetworkScheduleRepo";
import AllSchedules from "./schedule/AllSchedules";

export default function App(
    {scheduleRepo}: { scheduleRepo: ScheduleRepo }
) {
    return (
        <>
            <h1>全てのワークショップ</h1>
            <AllSchedules scheduleRepo={scheduleRepo}/>
        </>
    )
}
