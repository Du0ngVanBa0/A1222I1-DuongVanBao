import logo from './logo.svg';
import './App.css';
import React, {useState} from "react";
import {Formik} from "formik";
import {ToastContainer, toast} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css'

function App() {
    const notifySuccessfully = () => toast.success('Add contract successfully');
    const REGEX = {email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/};
    const [form, setForm] = useState({});

    function handleChange(event) {
        setForm({
            ...form,
            [event.target.name]: event.target.value
        })
    }

    function handleValidate() {
        const errors = {};
        if (!form.email) {
            errors.email = "required";
            console.log("em1")
        } else if (!REGEX.email.test(form.email)) {
            errors.email = "Invalid email address";
        }
        if (!form.name) {
            errors.name = "required";
            console.log("em2")
        }
        if (!form.phone) {
            errors.phone = "required";
            console.log("em3")
        }
        if (!form.message) {
            errors.message = "required";
            console.log("em4")
        }
        return errors;
    }

    function handleSubmit() {
        notifySuccessfully();
    }

    return (
        <div>
            <h1>Contact Form</h1>
            <Formik initialValues={form} onSubmit={handleSubmit} validate={handleValidate}>
                {({errors, handleSubmit}) => (
                    <form onSubmit={handleSubmit}>
                        <div
                            className={`custom-input ${
                                errors.email ? "custom-input-error" : ""}`}>
                            <label>Email</label>
                            <input
                                type="text"
                                name="email"
                                value={form.email || ""}
                                onChange={handleChange}
                            />
                            <p className="error">{errors.email}</p>
                        </div>
                        <div
                            className={`custom-input ${
                                errors.name ? "custom-input-error" : ""}`}>
                            <label>Name</label>
                            <input
                                type="text"
                                name="name"
                                value={form.name || ""}
                                onChange={handleChange}
                            />
                            <p className="error">{errors.name}</p>
                        </div>
                        <div
                            className={`custom-input ${
                                errors.phone ? "custom-input-error" : ""}`}>
                            <label>Phone</label>
                            <input
                                type="text"
                                name="phone"
                                value={form.phone || ""}
                                onChange={handleChange}
                            />
                            <p className="error">{errors.phone}</p>
                        </div>
                        <div
                            className={`custom-input ${
                                errors.message ? "custom-input-error" : ""}`}>
                            <label>Message</label>
                            <textarea
                                name="message"
                                value={form.message || ""}
                                onChange={handleChange}
                            />
                            <p className="error">{errors.message}</p>
                        </div>
                        <button type="submit">Submit</button>
                    </form>
                )}
            </Formik>
            <ToastContainer
                position="bottom-right"
                autoClose={5000}
                hideProgressBar={false}
                newestOnTop={false}
                closeOnClick
                rtl={false}
                pauseOnFocusLoss
                draggable
                pauseOnHover
                theme="light"
            />
        </div>
    );
}

export default App;
