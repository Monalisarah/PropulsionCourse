import React, {Component} from 'react';
import TodoItem from '../TodoItem';

class TodoList extends Component {

  constructor(props){
    super(props);
      this.state = {
        todos: ['Master JS', 'Learn React', 'Learn Redux']
      };
  //     setTimeout(() => {
  //   this.setState({
  //     todos: ['Master JS', 'Learn Redux']
  //   });
  // }, 3000);
}


  render() {

    console.log('TodoList Props: ', this.props);
    return (
      <ul>
        {
          this.state.todos.map((element, index) => {
            return <TodoItem key={ index } todo={ element }/>;
          })
        }
      </ul>
    )
  }
}

export default TodoList;

//
// <p className = "TodoList" >To do List</p>
