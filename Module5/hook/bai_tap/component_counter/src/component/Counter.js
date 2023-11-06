import React, {useState} from "react";

export default function useIncrement(addAmount) {
    const [count, setCount] = useState(0);

    function increase() {
        setCount((prevState) => {
            return prevState + addAmount
        });
    }

    return [count, increase];
}