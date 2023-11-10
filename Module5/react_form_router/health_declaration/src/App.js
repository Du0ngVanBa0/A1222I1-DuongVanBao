import 'bootstrap/dist/css/bootstrap.css'
import {ErrorMessage, Field, Form, Formik} from "formik";
import React, {useState} from "react";
import * as Yup from 'yup';
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './App.css';

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
        email: Yup.string()
            .required("Required")
            .matches(/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/, "Invalid Email"),
        name: Yup.string()
            .required("Required"),
        identityCard: Yup.string()
            .required("Required"),
        yearOfBirth: Yup.number()
            .required("Required")
            .min(1900, ">=1900"),
        nationality: Yup.string()
            .required("Required"),
        province: Yup.string()
            .required("Required"),
        district: Yup.string()
            .required("Required"),
        wards: Yup.string()
            .required("Required"),
        houseDetail: Yup.string()
            .required("Required"),
        phone: Yup.string()
            .required("Required"),
    }
    const handleSubmit = () => {
        notifySubmit();
    }
    return (
        <div className="container">
            <h1>Tờ khai y tế</h1>
            <Formik onSubmit={(value) => handleSubmit} initialValues={form}
                    validationSchema={Yup.object(handleValidate)}>
                {({isValid, dirty}) => (
                    <Form>
                        <div className='mb-3'>
                            <label htmlFor='name' className='form-label'>Họ tên</label>
                            <Field type='text' className='form-control' name="name" id='name'/>
                            <ErrorMessage name="name" component="span" className="text-danger"></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='identityCard' className='form-label'>Số hộ chiếu/CMND</label>
                            <Field type='text' className='form-control' name="identityCard" id='identityCard'/>
                            <ErrorMessage name="identityCard" component="span" className="text-danger"></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='yearOfBirth' className='form-label'>Năm sinh</label>
                            <Field type='text' className='form-control' name="yearOfBirth" id='yearOfBirth'/>
                            <ErrorMessage name="yearOfBirth" component="span" className="text-danger"></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='quantity' className='form-label'>Giới tính</label>
                            <div className="form-check">
                                <Field className="form-check-input" type="checkbox" value="" id="flexCheckDefault"/>
                                <label className="form-check-label" htmlFor="flexCheckDefault">Nam</label>
                            </div>
                            <div className="form-check">
                                <Field className="form-check-input" type="checkbox" value="" id="flexCheckChecked"/>
                                <label className="form-check-label" htmlFor="flexCheckChecked">Nữ</label>
                            </div>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='nationality' className='form-label'>Quốc tịch</label>
                            <Field type='text' className='form-control' name="nationality" id='nationality'/>
                            <ErrorMessage name="nationality" component="span" className="text-danger"></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='comp' className='form-label'>Công ty làm việc</label>
                            <Field type='text' className='form-control' name="comp" id='comp'/>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='part' className='form-label'>Bộ phận làm việc</label>
                            <Field type='text' className='form-control' name="part" id='part'/>
                        </div>
                        <div className='mb-3'>
                            <Field type='checkbox' className='form-check-input' name="insurance" id='insurance'/>
                            <label htmlFor='insurance' className='form-label'>Có thẻ bảo hiểm y tế</label>
                        </div>
                        <h3>Địa chỉ liên lạc tại Việt Nam</h3>
                        <div className='mb-3'>
                            <label htmlFor='province' className='form-label'>Tỉnh thành</label>
                            <Field type='text' className='form-control' name="province" id='province'/>
                            <ErrorMessage name="province" component="span" className="text-danger"></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='district' className='form-label'>Quận/huyện</label>
                            <Field type='text' className='form-control' name="district" id='district'/>
                            <ErrorMessage name="district" component="span" className="text-danger"></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='wards' className='form-label'>Phường/xã</label>
                            <Field type='text' className='form-control' name="wards" id='wards'/>
                            <ErrorMessage name="wards" component="span" className="text-danger"></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='houseDetail' className='form-label'>Số nhà, phố, tổ dân phố/thôn/đội</label>
                            <Field type='text' className='form-control' name="houseDetail" id='houseDetail'/>
                            <ErrorMessage name="houseDetail" component="span" className="text-danger"></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='phone' className='form-label'>Điện thoại</label>
                            <Field type='text' className='form-control' name="phone" id='phone'/>
                            <ErrorMessage name="phone" component="span" className="text-danger"></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='email' className='form-label'>Email</label>
                            <Field type='text' className='form-control' name="email" id='email'/>
                            <ErrorMessage name="email" component="span" className="text-danger"></ErrorMessage>
                        </div>
                        <button disabled={!isValid || !dirty} type='submit' className='btn btn-primary'>Submit</button>
                    </Form>
                )}
            </Formik>
            <ToastContainer/>
        </div>
    );
}

export default App;
