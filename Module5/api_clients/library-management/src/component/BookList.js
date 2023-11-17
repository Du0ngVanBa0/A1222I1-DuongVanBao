import React, {useEffect, useState} from "react";
import * as LibraryService from "../service/LibraryService"
import {useNavigate} from "react-router";

function BookList() {
    const navigate = useNavigate();
    const [bookList, setBookList] = useState([]);
    const getAllBook = async () => {
        let temp = await LibraryService.getAll();
        setBookList(temp);
    }
    useEffect(() => {
        getAllBook();
    }, []);
    if (!bookList) {
        return null;
    }

    function directToCreate() {
        navigate("/create");
    }

    function directToUpdate(id) {
        navigate(`/edit/${id}`);
    }

    const handleDelete = async (id) => {
        await LibraryService.deleteById(id);
        setBookList(prevState => {
            return [...prevState.filter(value => {
                return (value.id !== id);
            })]
        })
    }

    return (
        <>
            <h2>Library</h2>
            <button className="btn btn-success" onClick={() => directToCreate()}>Add a new book</button>
            <table className="table table-striped">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Quantity</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                {bookList.map((value, index) => {
                    return (
                        <tr key={index}>
                            <td>{value.title}</td>
                            <td>{value.quantity}</td>
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

export default BookList;