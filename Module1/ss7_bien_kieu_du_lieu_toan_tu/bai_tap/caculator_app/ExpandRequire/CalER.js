let ch = 0;
function AddKey(value) {
    if(document.getElementById('Result').innerHTML=='0')
        document.getElementById('Result').innerHTML=value;
    else
        document.getElementById('Result').innerHTML+=value;
}
function Evaluate() {
    let find=document.getElementById('Result').innerHTML;
    let result=eval(find);

    document.getElementById('SupResult').innerHTML=find;
    document.getElementById('Result').innerHTML=result;

    if(document.getElementById('Result').innerHTML!='0')
    {
        ch=1;
        document.getElementById('CE').innerHTML='AC';
    }
}
function Clear() {
    if(ch==0)
        ClearEntry();
    else
        AllClear();
}
function ClearEntry() {
    document.getElementById('Result').innerHTML
        =document.getElementById('Result').innerHTML
        .slice(0,document.getElementById('Result').innerHTML.length-1);

    if(document.getElementById('Result').innerHTML.length==0)
        document.getElementById('Result').innerHTML='0';
}
function AllClear() {
    let find=document.getElementById('Result').innerHTML;
    let result=eval(find);

    document.getElementById('SupResult').innerHTML=find;
    document.getElementById('Result').innerHTML='0';

    ch=0;
    document.getElementById('CE').innerHTML='CE';
}