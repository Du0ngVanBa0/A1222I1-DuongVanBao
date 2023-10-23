let fibonacci = function(n){
    if (n==1){
        return 0;
    }
    if  (n==2){
        return 1;
    }
    return fibonacci(n-1) + fibonacci(n-2);
};

let sumFibonacci = function(n){
    let fibonacciArr = [];
    for (let i = 1; i <= n ; i++) {
        fibonacciArr.push(fibonacci(i));
    }
    console.log(fibonacciArr)
    return fibonacciArr.reduce((previousValue, currentValue) => previousValue + currentValue);
}
7
console.log(sumFibonacci());