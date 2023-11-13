import logo from './logo.svg';
import './App.css';
import {Login} from "./components/Login";
import {Employee} from "./components/Employee.js";
import {EmployeeDetail} from "./components/EmployeeDetail.js";
import {Routes, Route, BrowserRouter} from 'react-router-dom'
import React from "react";

function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path="/employee" element={<Employee/>}/>
                    <Route path="/employee/:employeeId" element={<EmployeeDetail/>}/>
                    <Route path="/login" element={<Login/>}/>
                </Routes>
            </BrowserRouter>
        </>
    );
}

export default App;
