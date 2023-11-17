import axios from "axios";

export const getAll = async () => {
    let temp = await axios.get("http://localhost:8080/book");
    return temp.data;
}

export const getById = async (id) => {
    let temp = await axios.get("http://localhost:8080/book/" + id);
    return temp.data;
}

export const create = async (data) => {
    let temp = await axios.post("http://localhost:8080/book", data);
    return temp.status;
}

export const deleteById = async (id) => {
    let temp = await axios.delete("http://localhost:8080/book/" + id);
    return temp.status;
}

export const update = async (id, data) => {
    let temp = await axios.put("http://localhost:8080/book/" + id, data);
    return temp.status;
}
