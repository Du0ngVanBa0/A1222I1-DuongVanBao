import React, {useState} from "react";
import {Field, Form, Formik} from "formik";
import * as LibraryService from "../service/LibraryService"
import {useNavigate} from "react-router";

function BookCreate() {
    const navigate = useNavigate();
    const [form, setForm] = useState({
        "id": 0,
        "title": "",
        "quantity": 0
    });
    const handleSubmit = (values) => {
        console.log(values);
        let status = LibraryService.create(values);
        alert(status);
        navigate("/");
    }

    return (
        <>
            <h2>Add a new book</h2>
            <Formik onSubmit={(values) => handleSubmit(values)} initialValues={form} enableReinitialize={true}>
                <Form>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="title">Title</label>
                        <Field className="form-control" name="title" type="text" id="title"></Field>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="quantity">Quantity</label>
                        <Field className="form-control" name="quantity" type="number" id="quantity"></Field>
                    </div>
                    <button type="submit" className="btn btn-success">Add</button>
                </Form>
            </Formik>
        </>
    )
}

export default BookCreate;