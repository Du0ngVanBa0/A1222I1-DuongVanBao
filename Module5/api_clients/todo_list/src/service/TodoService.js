import axios from 'axios';

export const getAll = async () => {
    let temp = await axios.get("https://jsonplaceholder.typicode.com/todos");
    return temp.data;
}

export const submit = async () => {
    let temp = await axios.post("https://jsonplaceholder.typicode.com/todos");
    console.log(temp)
    return temp.status;
}