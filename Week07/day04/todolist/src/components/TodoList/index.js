import React, {Component} from 'react';

class TodoList extends Component {
  render() {
    const todos = ['Master JS', 'Learn React', 'Learn Redux'];

    return (
      <ul>
        {
          todos.map((todo, index) => {
            return <li key={index}>{ todo }</li>;
          })
        }
      </ul>
    )
  }
}

export default TodoList;

//
// <p className = "TodoList" >To do List</p>
