import React from "react";
import "bootstrap/dist/css/bootstrap.css"

class StudentInfoComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            students:
                [
                    {
                        id: 1,
                        name: "a du",
                        age: 18,
                        address: "Ha Loi"
                    },
                    {
                        id: 2,
                        name: "a gfdsg",
                        age: 18,
                        address: "ads Loi"
                    },
                    {
                        id: 3,
                        name: "a gsdf",
                        age: 18,
                        address: "Ha dasfa"
                    },
                    {
                        id: 4,
                        name: "a das",
                        age: 18,
                        address: "dasd Loi"
                    },
                    {
                        id: 5,
                        name: "a vsd",
                        age: 18,
                        address: "Ha dasd"
                    },
                    {
                        id: 6,
                        name: "a 123",
                        age: 18,
                        address: "gdffgdf Loi"
                    },
                ]
        }
    }

    render() {
        return (
            <div className="container">
                <table className="table table-striped">
                    <thead>
                    <th>id</th>
                    <th>name</th>
                    <th>age</th>
                    <th>address</th>
                    </thead>
                    <tbody>
                    {this.state.students.map((value) => {
                        return (
                            <tr key={value.id}>
                                <td>{value.id}</td>
                                <td>{value.name}</td>
                                <td>{value.age}</td>
                                <td>{value.address}</td>
                            </tr>
                        )
                    })}
                    </tbody>
                </table>
            </div>
        )
    }
}

export default StudentInfoComponent