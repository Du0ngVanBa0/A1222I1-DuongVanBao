import "bootstrap/dist/css/bootstrap.css"
import React from "react";

class Calculator extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            firstNum: 0,
            secondNum: 0,
            result: 0
        }
    }

    changeFirstNumber = (properties, value) => {
        this.setState({[properties]: parseInt(value)})
    }

    showResult = (expression) => {
        switch (expression) {
            case "+":
                this.setState({result: this.state.firstNum + this.state.secondNum})
                break;
            case "-":
                this.setState({result: this.state.firstNum - this.state.secondNum})
                break;
            case "*":
                this.setState({result: this.state.firstNum * this.state.secondNum})
                break;
            case "/":
                this.setState({result: this.state.firstNum / this.state.secondNum})
                break;
        }
    }

    render() {
        return (
            <>
                <div className="input-group flex-nowrap">
                    <input type="number" onChange={(evt) => this.changeFirstNumber("firstNum", evt.target.value)}
                           className="form-control" placeholder="First Number"
                           aria-label="First Number"
                           aria-describedby="addon-wrapping"/>
                </div>
                <div className="input-group flex-nowrap">
                    <input type="number" onChange={(evt) => this.changeFirstNumber("secondNum", evt.target.value)}
                           className="form-control" placeholder="Second Number" aria-label="Second Number"
                           aria-describedby="addon-wrapping"/>
                </div>
                <button type="button"  value='+' onClick={(evt)=>this.showResult(evt.currentTarget.value)} className="btn btn-primary">+</button>
                <button type="button"  value='-' onClick={(evt)=>this.showResult(evt.currentTarget.value)} className="btn btn-secondary">-</button>
                <button type="button"  value='*' onClick={(evt)=>this.showResult(evt.currentTarget.value)} className="btn btn-success">*</button>
                <button type="button"  value='/' onClick={(evt)=>this.showResult(evt.currentTarget.value)} className="btn btn-danger">/</button>
                <div className="p-3 text-bg-success border border-primary-subtle rounded-3">
                    {this.state.result}
                </div>
            </>
        )
    }

}

export default Calculator