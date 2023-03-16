

let lname : string;
lname="Student1";
let newName=lname.toUpperCase();
console.log(newName);

let age: number;
age=53;

let dob="25";
let result=parseInt(dob);
let isValid:boolean;
isValid=true;
console.log(isValid);

let array: string[];
array=["student1","student2","student3"];
let deptListCode:Array<number>;

deptListCode=[2,6,1,8,0];

let s=deptListCode.filter((num)=>num>2);
let t=deptListCode.find((num)=>num===6);
let p=deptListCode.reduce((acc,num)=>acc+num);

console.log(t);
console.log(s);
console.log(p);

const enum Color{
  Red,
  Green,
  Blue
}

let c: Color=Color.Red;

let swapNums: [fistNum:number,secondNum:number];

function swapNumbers(num1:number,num2:number):[number,number]{
  return[num2,num1];
}

swapNums=swapNumbers(10,20);
swapNums[0];

let something:any;
