import {useNavigate, useParams} from "react-router";
import React, {useEffect, useState} from "react";
import * as LibraryService from "../service/LibraryService";
import {Field, Form, Formik} from "formik";

function BookEdit() {
    const navigate = useNavigate();
    const {id} = useParams("id");
    const [form, setForm] = useState({
        "id": 0,
        "title": "",
        "quantity": 0
    });
    const handleSubmit = async (values) => {
        console.log(values);
        let status = await LibraryService.update(id, values);
        alert(status);
        navigate("/");
    }
    useEffect(() => {
        console.log(id)
        getBook(id);
    }, []);
    const getBook = async (id) => {
        let editBook = await LibraryService.getById(id);
        setForm(prevState => {
            return {...prevState, ...editBook}
        })
    }

    return (
        <>
            <h2>Edit book</h2>
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
                    <button type="submit" className="btn btn-success">Edit</button>
                </Form>
            </Formik>
        </>
    )
}

export default BookEdit;