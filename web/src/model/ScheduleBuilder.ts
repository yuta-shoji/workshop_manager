import {Participant} from "./Participant";
import {Schedule} from "./Schedule";

export default class ScheduleBuilder {
    private title: string
    private participants: Participant[]

    constructor() {
        this.title = ''
        this.participants = []
    }

    withTitle(newValue: string): ScheduleBuilder {
        this.title = newValue
        return this
    }

    withParticipants(newValue: Participant[]): ScheduleBuilder {
        this.participants = newValue
        return this
    }

    build(): Schedule {
        return {
            title: this.title,
            participants: this.participants
        }
    }
}