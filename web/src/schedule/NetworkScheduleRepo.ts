import {ScheduleResults} from "../model/ScheduleResults";
import {Http} from "../networking/NetworkHttp";

export default interface ScheduleRepo {
    getAllSchedules(): Promise<ScheduleResults>
}

export class NetworkScheduleRepo implements ScheduleRepo {
    private http: Http

    constructor(http: Http) {
        this.http = http
    }

    async getAllSchedules(): Promise<ScheduleResults> {
        return await this.http.get('/api/schedule') as ScheduleResults
    }
}