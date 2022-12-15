import {Http, NetworkHttp} from "../../networking/NetworkHttp";
import axios from "axios";

describe('network http', () => {
    describe('get requests', () => {
        let networkHttp: Http

        beforeEach(() => {
            process.env.REACT_APP_SERVER_URL = 'http://server-name:9999'

            axios.get = jest.fn(() =>
                Promise.resolve({
                    data: [{stubData: 'hoge'}],
                })
            ) as jest.Mock

            networkHttp = new NetworkHttp()
        })

        afterEach(() => jest.restoreAllMocks())

        test('axiosに正しくurlを渡している', async () => {
            await networkHttp.get('/api/schedule')

            expect(axios.get).lastCalledWith('http://server-name:9999/api/schedule')
        })

        test('axiosが正しくresponseを返す', async () => {
            const response = await networkHttp.get('')
            expect(response).toEqual([{stubData: 'hoge'}])
        })
    })
})