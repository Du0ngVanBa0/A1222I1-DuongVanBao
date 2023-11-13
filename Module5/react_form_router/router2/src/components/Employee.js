import {useLocation, useNavigate} from "react-router";

export function Employee() {
    const navigate = useNavigate();
    const location = useLocation();
    const data = location.state;
    const employees = [
        {
            id: 1,
            name: "Hoa",
            age: 20
        },
        {
            id: 2,
            name: "Khánh",
            age: 25
        },
        {
            id: 3,
            name: "Tú",
            age: 22
        },
    ]

    function handleClick(value) {
        navigate("/employee/" + value)
    }

    return (
        <>
            <h1>Hello {data.username}</h1>
            <table>
                <thead>
                <th>id</th>
                <th>name</th>
                <th>age</th>
                </thead>
                <tbody>
                {employees.map((value, index) => {
                    return (
                        <tr key={index}>
                            <td>{value.id}</td>
                            <td>{value.name}</td>
                            <td>{value.age}</td>
                            <td>
                                <button onClick={() => handleClick(value.id)}>Detail</button>
                            </td>
                        </tr>
                    )
                })}
                </tbody>
            </table>
        </>
    )
}