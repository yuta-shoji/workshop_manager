import App from "../App";
import {render} from "@testing-library/react";
import {act} from "react-dom/test-utils";
import {BrowserRouter} from "react-router-dom";
import ScheduleRepo from "../schedule/NetworkScheduleRepo";

export default async function renderApplication(url: string, scheduleRepo: ScheduleRepo) {
    await act(async () => {
        window.history.pushState({}, '', url)
        render(
            <BrowserRouter>
                <App scheduleRepo={scheduleRepo}/>
            </BrowserRouter>
        )
    })
}