import React from 'react';
import {SpyStubHttp} from "./networking/SpyStubHttp";
import renderApplication from "./RenderApplication";
import {screen} from "@testing-library/react";
import {StubNetworkScheduleRepo} from "./schedule/StubNetworkScheduleRepo";

let stubScheduleRepo: StubNetworkScheduleRepo

beforeEach(() => {
    stubScheduleRepo = new StubNetworkScheduleRepo()
})

test('「全てのワークショップ」の文字が見える', async () => {
    await renderApplication('/', stubScheduleRepo)
    const allWorkshops = screen.getByText('全てのワークショップ')

    expect(allWorkshops).toBeInTheDocument()
})