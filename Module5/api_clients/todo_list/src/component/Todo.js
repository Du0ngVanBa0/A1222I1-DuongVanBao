import React, {useEffect, useState} from "react";
import * as TodoService from "../service/TodoService.js"

function Todo() {
    const [list, setList] = useState([]);
    const getAllList = async () => {
        let temp = await TodoService.getAll();
        console.log(temp);
        setList(temp);
    };
    const handleSubmit = async () => {
        let temp = await TodoService.submit();
        alert(temp);
    }
    useEffect(() => {
        getAllList();
    }, []);
    return (
        <>
            <h2>Todo List</h2>
            <input type="text"/>
            <button className="btn btn-primary" onClick={() => handleSubmit()}>Submit</button>
            <ul>
                {list.map((value, index) => {
                    return (
                        <li key={index}>{value.title}</li>
                    )
                })}
            </ul>
        </>
    )
}

export default Todo;