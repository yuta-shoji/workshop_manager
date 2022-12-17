import ScheduleRepo from "../../schedule/NetworkScheduleRepo";
import {ScheduleResults} from "../../model/ScheduleResults";

export class StubNetworkScheduleRepo implements ScheduleRepo {
    getAllSchedules_returnValue: Promise<ScheduleResults> = Promise.resolve({allCount: 0, results: []})
    getAllSchedules(): Promise<ScheduleResults> {
        return this.getAllSchedules_returnValue
    }
}