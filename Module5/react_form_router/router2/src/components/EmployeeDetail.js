import {useParams} from "react-router";

export function EmployeeDetail() {
    const {employeeId} = useParams("employeeId");
    console.log(employeeId);
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

    return (
        <>
            {employeeId &&
            <>
                <h1>{employees[employeeId - 1].id}</h1>
                <h1>{employees[employeeId - 1].name}</h1>
                <h1>{employees[employeeId - 1].age}</h1>
            </>
            }
        </>
    )
}