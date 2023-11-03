import logo from './logo.svg';
import './App.css';
import {useState} from "react";

const carList = ["mkem", "mlem", "longBe", "abe"];
const colorList = ["red", "yellow", "orange", "purple"]

function App() {
    const [selectedCar, setSelectedCar] = useState({car: "", color: ""})

    const handleChange = (prop, value) => {
        setSelectedCar((prevState) => {
            return {
                ...prevState,
                [prop]: value
            }
        })
    }

    return (
        <div>
            <h3>Select your Car</h3>
            <div>
                <span>Select a car</span>
                <select value={selectedCar.car} onChange={(e) => handleChange("car", e.target.value)}>
                    {carList.map((value, index) => {
                        return <option key={index}>{value}</option>
                    })}
                </select>
            </div>
            <div>
                <span>Select a color</span>
                <select value={selectedCar.color} onChange={(e) => handleChange("color", e.target.value)}>
                    {colorList.map((value, index) => {
                        return <option key={index}>{value}</option>
                    })}
                </select>
            </div>
            <h3>You selected a {selectedCar.color} - {selectedCar.car}</h3>
        </div>
    );
}

export default App;
