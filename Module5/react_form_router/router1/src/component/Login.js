import {useNavigate} from "react-router-dom";
import React, {useState} from "react";
import {Field, Form, Formik} from 'formik'

export function Login() {
    const navigate = useNavigate();
    const [form, setForm] = useState({username: "", password: ""});
    // const handleChange = event => {
    //     setForm(prevState => {
    //         return {...prevState, [event.target.name]: event.target.value};
    //     })
    // }
    const handleSubmit = (value) => {
        navigate("/home",{state: value})
        console.log(value)
    }

    return (
        <>
            <div className="tab-content">
                <div className="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
                    <Formik initialValues={form} onSubmit={(values) => {
                        handleSubmit(values)
                    }}>
                        <Form>
                            <div className="form-outline mb-4">
                                <Field type="text" name='username'
                                       id="loginName" className="form-control"/>
                                <label className="form-label" htmlFor="loginName">username</label>
                            </div>
                            <div className="form-outline mb-4">
                                <Field type="password" name='password'
                                       id="loginPassword" className="form-control"/>
                                <label className="form-label" htmlFor="loginPassword">Password</label>
                            </div>
                            <div className="row mb-4">
                                <div className="col-md-6 d-flex justify-content-center">
                                    <a href="#!">Forgot password?</a>
                                </div>
                            </div>
                            <button type="submit" className="btn btn-primary btn-block mb-4">Sign in</button>

                            <div className="text-center">
                                <p>Not a member? <a href="#!">Register</a></p>
                            </div>
                        </Form>
                    </Formik>
                </div>
            </div>
        </>
    )
}