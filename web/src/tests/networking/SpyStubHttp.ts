import {Http} from "../../networking/NetworkHttp";

export class SpyStubHttp implements Http {
    get_argument_url?: string
    get_returnValue: Promise<object> = Promise.resolve({})

    get(url: string): Promise<object> {
        this.get_argument_url = url
        return this.get_returnValue
    }
}