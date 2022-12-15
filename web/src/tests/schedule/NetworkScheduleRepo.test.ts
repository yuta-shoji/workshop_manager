import {NetworkScheduleRepo} from "../../schedule/NetworkScheduleRepo";
import {SpyStubHttp} from "../networking/SpyStubHttp";
import {Schedule} from "../../model/Schedule";


describe('Network schedule repository', () => {
    let spyStubNetworkHttp: SpyStubHttp
    let networkScheduleRepo: NetworkScheduleRepo

    beforeEach(() => {
        spyStubNetworkHttp = new SpyStubHttp()
        networkScheduleRepo = new NetworkScheduleRepo(spyStubNetworkHttp)
    })

    describe('get all schedules', () => {
        test('http.getに正しくurlを渡して実行している', async () => {
            await networkScheduleRepo.getAllSchedules()

            expect(spyStubNetworkHttp.get_argument_url).toEqual('/api/schedule')
        })

        test('httpからのレスポンスJSONをparseして返す', async () => {
            const expectResults: Schedule[] = [{
                'title': 'workshop title',
                'participants': [
                    {
                        'id': 0,
                        'participatingTitle': 'workshop title',
                        'firstName': 'hogetaro',
                        'lastName': 'hogeyama',
                        'age': 5,
                        'parentsFirstName': 'hogehiro',
                        'parentsLastName': 'hogeyama',
                    }
                ]
            }]
            spyStubNetworkHttp.get_returnValue = Promise.resolve({
                'allCount': 1,
                'results': expectResults,
            })

            const responseSchedules = await networkScheduleRepo.getAllSchedules()

            expect(responseSchedules.allCount).toEqual(1)
            expect(responseSchedules.results).toEqual(expectResults)
        })
    })

})