import React, {useEffect, useState} from "react";
import * as ContactService from "../service/ContactService"
import {useNavigate} from "react-router";
import * as LibraryService from "../../../library-management/src/service/LibraryService";

function ContactList() {
    const [contactList, setContactList] = useState([]);
    const navigate = useNavigate();
    const getAll = async () => {
        let temp = await ContactService.getAll();
        setContactList(temp);
    }
    useEffect(() => {
        getAll();
    }, [])

    function directToCreate() {
        navigate("/create");
    }

    const handleDelete = async (id) => {
        await LibraryService.deleteById(id);
        setBookList(prevState => {
            return [...prevState.filter(value => {
                return (value.id !== id);
            })]
        })
    }

    function directToUpdate(id) {
        navigate(`/edit/${id}`);
    }

    return (
        <>
            <h2>COntact</h2>
            <button className="btn btn-success" onClick={() => directToCreate()}>Add a new contact</button>
            <table className="table table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                {contactList.map((value, index) => {
                    return (
                        <tr key={index}>
                            <td><img width="50px" className="img-fluid" src={value.image}/>{value.name}</td>
                            <td>{value.email}</td>
                            <td>{value.phone}</td>
                            <td>
                                <button className="btn btn-primary" onClick={() => directToUpdate(value.id)}>Edit
                                </button>
                                <button className="btn btn-danger" onClick={() => handleDelete(value.id)}>Delete
                                </button>
                            </td>
                        </tr>
                    )
                })}
                </tbody>
            </table>
        </>
    )
}

export default ContactList;