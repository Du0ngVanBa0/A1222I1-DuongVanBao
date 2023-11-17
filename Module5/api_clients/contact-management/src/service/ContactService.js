import axios from "axios"

export const getAll = async () => {
    let temp = await axios.get("http://localhost:8080/contacts");
    return temp.data;
}

export const getById = async (id) => {
    let temp = await axios.get(`http://localhost:8080/contacts/${id}`);
    return temp.data;
}

export const create = async (data) => {
    let temp = await axios.post("http://localhost:8080/contacts", data);
    return temp.data;
}

export const deleteById = async (id) => {
    let temp = await axios.delete("http://localhost:8080/contacts/" + id);
}

export const uploadFile = async (file) => {
    let result = '';
    const fd = new FormData();
    fd.append("file", file);
    await axios.post("https://v2.convertapi.com/upload", fd)
        .then(res => {
            result = res.data.Url;
        })
        .catch(err => {
            console.log(err);
        });
    return result;
}

export const update = async (id, data) => {
    let temp = await axios.put(`http://localhost:8080/contacts/${id}`, data);
    return temp.data;
}
