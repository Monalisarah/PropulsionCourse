import React from 'react';
import './index.css'

class TodoList extends React.Component {

  constructor(props){
    super(props);
    this.state = {
      todos: ['learn JS', 'learn React', 'learn Redux'],
      inputValue: '',
    }
  }

  addTodo = () => {
    console.log(this.state.inputValue);
    const newTodos = [...this.state.todos];
    newTodos.push(this.state.inputValue);
    this.setState({
      todos: newTodos,
    });
    console.log('in da addTodo');
  }

  handleInput = (e) => {
    console.log(e.currentTarget.value);
    console.log('in da handle');
    //we ar going to pass the new state which replacese the previous state
    this.setState({
      inputValue: e.currentTarget.value
    });
  }
  //React is changing the state, handle Changes, managig State
  // handleInput(e){
  //   console.log(e.currentTarget.value);
  //   console.log('in da handle');
  //   this.state.inputValue = e.currentTarget.value;
  // }

  render(){
    console.log('in da render');
    // const todos = ['learn JS', 'learn React', 'learn Redux'];
    // const todosItems =   todos.map(todo => {
    //     return <li key{ todo }>{todo}</li>;
    //   })
    return (
      <div className = "TodoList">
        <div>
        <input type="text" value= {this.state.inputValue} onChange={this.handleInput.bind(this)}/>
        {
          //"My value">
        //<input type="text" value= {this.state.inputValue} onChange={this.handleInput.bind(this)}/>//"My value">
        //bind creates a new function when the function was called the original functin was called with setting the parameter to the context
        //with the arrow function you have always the same context
        }
        <button onClick={this.addTodo}>Add Todo</button>
        </div>
        <ul>
          {

            // todos.map(todo => {
            //   return <li key{ todo }>{todo}</li>;
            // })
            this.renderTodos()
            // this.renderTodos()

          // <li>learn JS</li>
          // <li>learn React</li>
          }
        </ul>
      </div>
    )
  }


// renderTodos(){
//   const todos = ['learn JS', 'learn React', 'learn Redux'];
//   todos.map(todo => {
//       return <li key{ todo }>{todo}</li>;
//           })
// }

  renderTodos(){
    return this.state.todos.map(todo => {
      console.log(todo);
      return <li key={ todo }>{todo}</li>;
    })
  };
}


export default TodoList;
