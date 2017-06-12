console.log(Redux.store);


const reducer = (state = 0, action) => {
  switch (action.type) {
    case 'increment':
      return state + action.mount;
    default:
    return state;

  }
  console.log('in da reducer');
  console.log(state);
  console.log(action);
  return state;
}


const store = Redux.createStore(reducer);
console.log(store);

const increment = {
  type: 'increment',
  amount: 1,
};

function render(){
  const conterEl = document.getElementById('counter');
  const state = store.getState();
  counterEl.innerHTML = state;
}

render()

document
.getElementById('increment')
.addEventListener('click', (e) => {
  console.log('in da click');
  store.dispatch(increment);
  render()
}
