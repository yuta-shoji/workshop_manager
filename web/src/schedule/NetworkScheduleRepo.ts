import {ScheduleResults} from "../model/ScheduleResults";
import {Http} from "../networking/NetworkHttp";

export interface ScheduleRepo {
    getAllSchedules(): Promise<ScheduleResults>
}

export class NetworkScheduleRepo implements ScheduleRepo {
    private http: Http

    constructor(http: Http) {
        this.http = http
    }

    async getAllSchedules(): Promise<ScheduleResults> {
        const response = await this.http.get('/api/schedule') as ScheduleResults
        return {
            allCount: response.allCount,
            results: response.results
        }
    }
}