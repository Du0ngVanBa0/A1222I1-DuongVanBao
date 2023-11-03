import logo from './logo.svg';
import './App.css';
import React from "react";

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            studentList: [],
            form: {name: "", phone: "", email: ""},
            isValid: false,
            indexSelected: -1
        }
    }

    checkInvalidForm = () => {
        const {name, phone, email} = this.state.form
        const value = name && phone && email
        this.setState({
            isValid: value
        })
    }

    handleChange = (event) => {
        const {name, value} = event.target;
        // this.setState((state) => {
        //     let form = {...state.form}
        //     form = {...form,
        //     [name]: value}
        //
        //     return {...this.state, ...form}
        // }, () => this.checkInvalidForm())
        this.setState({...this.state, form: {...this.state.form, [name]:value}}, () => this.checkInvalidForm())
    }

    handleSubmit = () => {
        console.log(this.state)
        if (this.state.isValid) {
            const newList = [...this.state.studentList]
            if (this.state.indexSelected > -1) {
                newList.splice(this.state.indexSelected,1,this.state.form)
            } else {
                newList.push(this.state.form)
            }
            this.setState({...this.state, studentList: [...newList]})
        }
    }

    handleSelect = (studentSelected, index) => {
        this.setState({...this.state,
            form: {...studentSelected},
            indexSelected: index
        })
    }

    handleDelete = (index) => {
        this.setState((state) => {
            const studentList = state.studentList;
            studentList.splice(index, 1)
            return {studentList}
        })
    }

    render() {
        return (
            <div>
                <div>
                    <h1>Student List</h1>
                    <div>
                        <label>Name: </label>
                        <input name="name" value={this.state.form.name} onChange={(evt) => this.handleChange(evt)}/>
                    </div>
                    <div>
                        <label>Phone: </label>
                        <input type="number" name="phone" value={this.state.form.phone}
                               onChange={(evt) => this.handleChange(evt)}/>
                    </div>
                    <div>
                        <label>Email: </label>
                        <input name="email" value={this.state.form.email} onChange={(evt) => this.handleChange(evt)}/>
                    </div>
                    <button onClick={this.handleSubmit}>Submit</button>
                    <table>
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.studentList.map((student, index) => {
                                console.log(this.state.indexSelected)
                                console.log(index)
                                return <tr key={index}>
                                    <td>{student.name}</td>
                                    <td>{student.phone}</td>
                                    <td>{student.email}</td>
                                    <td>
                                        <button onClick={(e) => this.handleSelect(student, index)}>Edit
                                        </button>
                                        <button onClick={(index) => this.handleDelete(index)}>Delete</button>
                                    </td>
                                </tr>
                            })
                        }
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default App;
