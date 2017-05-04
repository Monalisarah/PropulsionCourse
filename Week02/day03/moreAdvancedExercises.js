var obj = {
  name: 'Markov'
}
function printName() {
  console.log('Thy name is: ' + this.name);
}


function myBind(fn, context){
  return function(){
    fn.call(context);
  }
}

var boundPrint = myBind(printName, obj);
boundPrint();
