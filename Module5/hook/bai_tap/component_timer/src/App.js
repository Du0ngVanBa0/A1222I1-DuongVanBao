import logo from './logo.svg';
import './App.css';
import {useEffect, useState} from "react";

function App() {
    const [timer, setTimer] = useState(10);
    useEffect(() => {
        const countdownInterval = setInterval(() => {
            if (timer == 0) {
                clearInterval(countdownInterval);
                alert("Time's up");
            } else
                setTimer(timer - 1);
        }, 500);
        //clear Interval
        return () => {
            clearInterval(countdownInterval);
        }
    }, [timer])

    return (
        <div>
            <h3>Count down: {timer}</h3>
        </div>
    );
}

export default App;
