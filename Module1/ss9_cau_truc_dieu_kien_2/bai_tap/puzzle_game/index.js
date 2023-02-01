let cell1 = document.getElementsByClassName('s1');
let cell2 = document.getElementsByClassName('s2');
let cell3 = document.getElementsByClassName('s3');
let cell4 = document.getElementsByClassName('s4');
function RandomPuzzle() {
    let num1 = Math.floor(Math.random()*cell1.length);
        placeIMG(cell1,num1);
    let num2 = Math.floor(Math.random()*cell2.length);
        placeIMG(cell2,num2);
    let num3 = Math.floor(Math.random()*cell3.length);
        placeIMG(cell3,num3);
    let num4 = Math.floor(Math.random()*cell4.length)
    while (num4==num3 && num3==num2 && num2==num1);
        placeIMG(cell4,num4);
}
function placeIMG(value,num) {
    value[num].classList.toggle('active');
}
function CheckPz() {
    let check = true;
    let active = document.getElementsByClassName('active');
    for(let i=0;i<3;i++)
        if (active[i].name!==active[i+1].name)
            check=false;
    console.log(check);
    if (check)
        document.getElementById('container').style.boxShadow="0px 0px 20px 10px red";
    else
        document.getElementById('container').style.boxShadow="none";

}
function ChangeP(value,obj) {
    let i = value != 2 ? (value + 1) : 0;
    obj.classList.toggle('active');
    let cl=obj.className;
    console.log(cl);

    if(cl=='s1')
        placeIMG(cell1,i);
    else
        if(cl=='s2')
            placeIMG(cell2,i);
        else
            if(cl=='s3')
                placeIMG(cell3,i);
            else
                placeIMG(cell4,i);
            
    CheckPz();
}