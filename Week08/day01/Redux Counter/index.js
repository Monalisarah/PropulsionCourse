const initialState = {
  counter: 0,
}



const reducer = function(state = initialState, action) {
  let newState;
  switch (action.type) {
    case "DECREMENT":
      newState = Object.assign({}, state);
      newState.counter --;
      return newState;
    case "INCREMENT":
    newState = Object.assign({}, state);
    newState.counter ++;
    return newState;
    default:
      return state;
  }
}

const store = Redux.createStore(reducer);

const render = () => {
  const counter = document.getElementById("counter");
  counter.innerHTML = store.getState().counter;
}

store.subscribe(render);


// action will always be the argument of the dispach
document
.getElementById("decrement")
.addEventListener("click", () => {
  console.log('click decrement');
  store.dispatch({type: "DECREMENT"})
});

document
.getElementById("increment")
.addEventListener("click", () => {
  console.log('click increment');
  store.dispatch({type: "INCREMENT"})
});
