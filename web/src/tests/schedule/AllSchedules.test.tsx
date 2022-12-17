import {screen} from '@testing-library/react'
import renderApplication from "../RenderApplication";
import {StubNetworkScheduleRepo} from "./StubNetworkScheduleRepo";

describe('All schedules', () => {
    let stubScheduleRepo: StubNetworkScheduleRepo

    beforeEach(() => {
        stubScheduleRepo = new StubNetworkScheduleRepo()
    })

    test('「全てのワークショップ」の文字が見える', async () => {
        await renderApplication('/', stubScheduleRepo)
        const allWorkshops = screen.getByText('全てのワークショップ')

        expect(allWorkshops).toBeInTheDocument()
    })
})