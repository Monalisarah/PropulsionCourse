
// npm install --save redux react --
// index: import store from './store' in the src file
// in the src file wrap the most parent component inside the material UI with  a component we import from react
// import {provider } from 'react-redux' in the src folder wrap the most parent with <provider store ={store}></provider>
// in the provider use the store you have
// any child of the provider can be connected to the store by it self, also nested children, any component
// in order to connect it we have to import:
// import {connect} from react-redux;


// in the TodoList folder index.js:
import {connect} from react-redux;


addTodo = (e) => {
  e.preventDefault();

  const action = {
    type: 'addTodo'
    content: this.state.inputValue,
  };

  }
}

render()


<ul>
{
  this.props.todos.map(todo => {
    return <TodoItem key={todo todo = {todo}} />;
  })
}
</ul>



const mapStateToProps = (state) =>{
  return{
    todos: state,
  };
}

const connection = connect(mapStateToProps);
const ConnectedTodoList = connection(TodoList);

export default ConnectedTodoList;






// in the store folder index.js:
import {createStore} from 'redux';


const reducer = (state [], action ) => {
  switch (action.type) {
    case 'addTodo':
    const newState = [...state];
    newState.push(action.content)
    return newState;
    default:
    return state;
  }
}


const store = createStore(recucer);

export default store;


//in the App.js

import React, {Component } from 'react';
...
