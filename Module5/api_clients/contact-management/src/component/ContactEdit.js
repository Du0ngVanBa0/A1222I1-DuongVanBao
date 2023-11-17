import React, {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router";
import {Field, Form, Formik} from "formik";
import * as ContactService from "../service/ContactService";

function ContactEdit() {
    const navigate = useNavigate();
    const {id} = useParams("id");
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
        await ContactService.update(id, values);
        navigate("/");
    }
    useEffect(() => {
        getContact(id);
    }, []);
    const getContact = async (id) => {
        let editContact = await ContactService.getById(id);
        setForm(prevState => {
            return {...prevState, ...editContact}
        })
    }
    const handleUpload = (e) => {
        setSelectedFile(e.target.files[0]);
    }
    return (
        <>
            <h2>Edit contact</h2>
            <Formik onSubmit={(values) => handleSubmit(values)} initialValues={form} enableReinitialize={true}>
                <Form>
                    <div className="mb-3">
                        <img width="50px" className="img-fluid" src={form.image}/>
                        <label className="form-label" htmlFor="image">Image</label>
                        <input className="form-control" type="file"
                               id="images" onChange={(e) => handleUpload(e)}></input>
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
                    <button type="submit" className="btn btn-success">Edit</button>
                </Form>
            </Formik>
        </>
    )
}

export default ContactEdit;