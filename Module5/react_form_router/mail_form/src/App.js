import './App.css';
import 'bootstrap/dist/css/bootstrap.css'
import {ErrorMessage, Field, Form, Formik} from "formik";
import React, {useState} from "react";
import * as Yup from 'yup';
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {
    const [form, setForm] = useState({});
    const handleChange = event => {
        setForm(prevState => {
            return {...prevState, [event.target.name]: event.target.value};
        })
    }
    const notifySubmit = () => {
        toast.success('Thêm liên hệ thành công', {
            position: "bottom-right",
            autoClose: 5000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
            theme: "light",
        });
    }
    const handleValidate = {
        to: Yup.string()
            .required("Required")
            .matches(/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,"Invalid Email"),
        title: Yup.string()
            .required("Required"),
        message: Yup.string()
            .required("Required")
    }
    const handleSubmit = () => {
        notifySubmit();
    }
    return (
        <div className="container">
            <Formik onSubmit={handleSubmit} initialValues={form} validationSchema={Yup.object(handleValidate)}>
                <Form>
                    <div className='mb-3'>
                        <label htmlFor='title' className='form-label'>To</label>
                        <Field type='text' className='form-control' name="to" id='to'/>
                        <ErrorMessage name="to" component="span" className="form-err"></ErrorMessage>
                    </div>
                    <div className='mb-3'>
                        <label htmlFor='quantity' className='form-label'>Title</label>
                        <Field type='text' className='form-control' name="title" id='title'/>
                        <ErrorMessage name="title" component="span" className="form-err"></ErrorMessage>
                    </div>
                    <div className='mb-3'>
                        <label htmlFor='quantity' className='form-label'>Message</label>
                        <Field as="textarea" className='form-control' name="message" id='message'/>
                        <ErrorMessage name="message" component="span" className="form-err"></ErrorMessage>
                    </div>
                    <div className='mb-3'>
                        <input type="file" as="textarea" className='form-control' name="message" id='message'/>
                        <ErrorMessage name="message" component="span" className="form-err"></ErrorMessage>
                    </div>
                    <button type='submit' className='btn btn-primary'>Submit</button>
                </Form>
            </Formik>
            <ToastContainer/>
        </div>
    );
}

export default App;
