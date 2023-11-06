import React from "react";
import Counter from "./Counter";
import useIncrement from "./Counter";

export default function Counter2() {
    const [count, setCount] = useIncrement(2);
    return (
        <>
            <p>Count {count}</p>
            <button onClick={() => setCount()}>Add 2</button>
        </>
    )
}