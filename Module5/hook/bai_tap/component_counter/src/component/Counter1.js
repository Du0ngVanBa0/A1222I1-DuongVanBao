import React from "react";
import Counter from "./Counter";
import useIncrement from "./Counter";

export default function Counter1() {
    const [count, setCount] = useIncrement(1);
    return (
        <>
            <p>Count {count}</p>
            <button onClick={() => setCount()}>Add 1</button>
        </>
    )
}