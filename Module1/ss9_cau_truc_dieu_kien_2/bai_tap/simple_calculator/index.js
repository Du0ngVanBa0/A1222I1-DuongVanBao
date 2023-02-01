function Add(value,display) {
    let board = document.getElementById('ResultNum');
    let draft = document.getElementById('EvalBox');

    board.innerHTML+=display;
    draft.innerHTML+=value;
}
function Eval() {
    let draft = document.getElementById('EvalBox');
    let result = eval(draft.innerHTML);
    document.getElementById('ResultNum').innerHTML=result;
    draft.innerHTML=result;
}
function Clear() {
    document.getElementById('ResultNum').innerHTML='';
    document.getElementById('EvalBox').innerHTML='';
}