const initialState = {
  counter: 0,
  todos: ['Learn Redux' , 'Master React']
}





const reducer = function(state = initialState, action) {
  let newState = Object.assign({}, state);
  switch (action.type) {
    case "DECREMENT":
      newState.counter --;
      return newState;
    case "INCREMENT":
      newState.counter ++;
      return newState;
    case "ADD":
      // const input = document.getElementById("input").value;
      newState.todos.push(action.input)
    default:
      return state;
  }
}

const store = Redux.createStore(reducer);

const render = () => {
  const counter = document.getElementById("counter");
  counter.innerHTML = store.getState().counter;

  const todo = document.getElementById("todo");
  todo.innerHTML = "";
  const todoElements = store.getState().todos;

    for (let i =0; i < todoElements.length; i++){
       const list = document.createElement("li")
       list.innerHTML =  todoElements[i];
       todo.appendChild(list)
      }
}

store.subscribe(render);
render();


// action will always be the argument of the dispach
document
.getElementById("decrement")
.addEventListener("click", () => {
  store.dispatch({type: "DECREMENT"})
});

document
.getElementById("increment")
.addEventListener("click", () => {
  store.dispatch({type: "INCREMENT"})
});

document
.getElementById("add")
.addEventListener("click", () =>{
  const input = document.getElementById("input").value;
  document.getElementById("input").value = "";
  store.dispatch({type: "ADD", input: input})
});
