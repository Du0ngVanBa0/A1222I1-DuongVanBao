import './App.css';
import "bootstrap/dist/css/bootstrap.css"
import React from "react";

class App extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            list: [],
            item: ""
        }
    }

    handleChange = (value) => {
        this.setState({
            item: value
        })
    }

    handleAddItem = () => {
        this.setState((prev) => {
            return {
                list: [...prev.list, prev.item]
            }
        })
    }

    render() {
        return (
            <div className="align-items-center text-center">
                <h3>Todo List</h3>
                <div className="input-group">
                    <input type="text" onChange={(evt) => this.handleChange(evt.target.value)}
                           className="form-control shadow-sm p-3 bg-body-tertiary rounded"
                           aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-default"/>
                    <button className="btn btn-primary" onClick={()=>this.handleAddItem()} type="submit">Add</button>
                </div>
                <table className="table">
                    <thead>
                    <th>List</th>
                    </thead>
                    <tbody>
                    {
                        this.state.list.map((value) => {
                            return (
                                <tr>
                                    <td>{value}</td>
                                </tr>)
                        })
                    }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default App;
