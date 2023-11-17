import './App.css';
import BookList from "./component/BookList";
import React from "react";
import {BrowserRouter} from "react-router-dom";
import {Routes, Route} from "react-router";
import BookEdit from "./component/BookEdit";
import BookCreate from "./component/BookCreate";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="edit/:id" element={<BookEdit/>}></Route>
                <Route path="create" element={<BookCreate/>}></Route>
                <Route path="" element={<BookList/>}></Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
