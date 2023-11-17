import logo from './logo.svg';
import './App.css';
import {BrowserRouter} from "react-router-dom";
import {Route, Routes} from "react-router";
import ContactList from "./component/ContactList";
import ContactCreate from "./component/ContactCreate";
import ContactEdit from "./component/ContactEdit";
import React from "react";

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path="edit/:id" element={<ContactEdit/>}></Route>
          <Route path="create" element={<ContactCreate/>}></Route>
          <Route path="" element={<ContactList/>}></Route>
        </Routes>
      </BrowserRouter>
  );
}

export default App;
