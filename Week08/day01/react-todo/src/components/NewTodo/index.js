import React, { Component } from 'react';
import './index.css';

class NewTodo extends Component {

  constructor(props) {
    super(props);

    this.state = {
      newTodo: ''
    }
  }

  handleAddTodo = () => {
    this.props.addTodo(this.state.newTodo);
    this.setState({ newTodo: '' });
  }

  handleNewTodoChange = (e) => {
    const newTodo = e.currentTarget.value;
    this.setState({ newTodo });
  }

  render() {
    return (
      <div className="NewTodo">
        <input
          type="text"
          placeholder="Add todo..."
          value={ this.state.newTodo }
          onChange={ this.handleNewTodoChange }
        />
        <button onClick={ this.handleAddTodo }>Add Todo</button>
      </div>
    )
  }
}

NewTodo.propTypes = {
  addTodo: React.PropTypes.func.isRequired
};

export default NewTodo;
