let fibonacci = function (n) {
    if (n == 1|| n == 2) {
        return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
};

let sumFibonacci = function (n) {
    let fibonacciArr = [];1
    for (let i = 1; i <= n; i++) {
        fibonacciArr.push(fibonacci(i));
    }
    console.log(fibonacciArr)
    return fibonacciArr.reduce((previousValue, currentValue) => previousValue + currentValue);
}

console.log(sumFibonacci(6));