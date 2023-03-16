function add(num1:number,num2:number):number{
  return num1+num2;
}

console.log(add(4,5));
const  sub=(num1:number,num2:number):number=>num1-num2;

function add2(num1:number,num2:number,...num3:number[]):number{
  return num1+num2+num3.reduce((a,b)=>a+b);
}

console.log(add2(2,5,7,9,10));

function getItems<Type>(items:Type[]):Type[]{
  return new Array<Type>().concat(items);
}

let concatNum=getItems<number>([1,3,5,6]);
let concatString=getItems<string>(["a","b","c","d"]);

console.log(concatNum);
console.log(concatString);
