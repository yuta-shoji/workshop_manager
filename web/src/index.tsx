import React from 'react';
import './index.css';
import App from './App';
import {NetworkHttp} from "./networking/NetworkHttp";
import {NetworkScheduleRepo} from "./schedule/NetworkScheduleRepo";
import {BrowserRouter} from "react-router-dom";
import ReactDOM from 'react-dom';
import * as serviceWorker from './serviceWorker'

const http = new NetworkHttp()
const networkScheduleRepo = new NetworkScheduleRepo(http)

ReactDOM.render(
    <BrowserRouter>
        <App scheduleRepo={networkScheduleRepo}/>
    </BrowserRouter>,
    document.getElementById('root')
)

serviceWorker.register()
