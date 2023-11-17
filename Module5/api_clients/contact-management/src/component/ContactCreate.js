import React, {useState} from "react";
import * as ContactService from "../service/ContactService"
import {Field, Form, Formik} from "formik";
import {useNavigate} from "react-router";

function ContactCreate() {
    const navigate = useNavigate();
    const [form, setForm] = useState({
        "name": "",
        "email": "",
        "phone": "",
        "image": ""
    })
    const [selectedFile, setSelectedFile] = useState();
    const handleSubmit = async (values) => {
        let img = await ContactService.uploadFile(selectedFile);
        values = {...values, "image": img};
        await ContactService.create(values);
        navigate("/");
    }

    const handleUpload = (e) => {
        setSelectedFile(e.target.files[0]);
    }

    return (
        <>
            <h2>Add a new contact</h2>
            <Formik onSubmit={(values) => handleSubmit(values)} initialValues={form} enableReinitialize={true}>
                <Form>
                    <div className="mb-3">
                        <input className="form-control" type="file"
                               onChange={(e) => handleUpload(e)}></input>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="name">Name</label>
                        <Field className="form-control" name="name" type="text" id="name"></Field>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="email">Email</label>
                        <Field className="form-control" name="email" type="text" id="email"></Field>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="phone">Phone</label>
                        <Field className="form-control" name="phone" type="text" id="phone"></Field>
                    </div>
                    <button type="submit" className="btn btn-success">Add</button>
                </Form>
            </Formik>
        </>
    )
}

export default ContactCreate;