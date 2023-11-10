import './App.css';
import {Field, Form, Formik, ErrorMessage} from 'formik'
import * as Yup from 'yup';
import {toast} from "react-toastify";
import 'bootstrap/dist/css/bootstrap.css'
import React, {useState} from "react";

function App() {
    const [books, setBooks] = useState([]);
    const [selectedBookIndex, setSelectedBookIndex] = useState(-1);

    const [bookInit, setBookInit] = useState({
        title: "",
        quantity: 0
    });

    const bookValidate = {
        title: Yup.string()
            .required("Required"),
        quantity: Yup.number()
            .required("Required")
    };

    const createBook = (book) => {
        if (selectedBookIndex === -1) {
            setBooks(prevState => {
                return [...prevState, book];
            });
        } else {
            setBooks(prevState => {
                let temp = [...prevState];
                temp[selectedBookIndex] = book;
                return temp;
            });
            setSelectedBookIndex(-1);
        }
        setBookInit(prev => {
            return {...prev, title: "", quantity: 0};
        });
    }

    const editBook = (index) => {
        let temp = books[index];
        setBookInit(temp);
        setSelectedBookIndex(index);
    }

    const deleteBook = (index) => {
        setBooks(prev => {
            let temp = [...prev];
            temp.splice(index, 1);
            return temp;
        })
    }

    return (
        <div className="container">
            <Formik initialValues={bookInit} onSubmit={(value) => createBook(value)}
                    validationSchema={Yup.object(bookValidate)} enableReinitialize={true}>
                <Form>
                    <div className='mb-3'>
                        <label htmlFor='title' className='form-label'>Title</label>
                        <Field type='text' className='form-control' name="title" id='title'/>
                        <ErrorMessage name="title" component="span" className="form-err"></ErrorMessage>
                    </div>
                    <div className='mb-3'>
                        <label htmlFor='quantity' className='form-label'>Quantity</label>
                        <Field type='text' className='form-control' name="quantity" id='quantity'/>
                        <ErrorMessage name="quantity" component="span" className="form-err"></ErrorMessage>
                    </div>
                    <button type='submit' className='btn btn-primary'>Submit</button>
                </Form>
            </Formik>
            <table className="table table-striped">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                {
                    books.map((values, index) => {
                        return (
                            <tr key={index}>
                                <td>{values.title}</td>
                                <td>{values.quantity}</td>
                                <td>
                                    <button className="btn btn-warning" onClick={(e) => editBook(index)}>Edit</button>
                                    <button className="btn btn-danger" onClick={(e) => deleteBook(index)}>Delete
                                    </button>
                                </td>
                            </tr>
                        )
                    })
                }
                </tbody>
            </table>
        </div>
    );
}

export default App;
