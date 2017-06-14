import React, { Component } from 'react';

import './index.css';

class TodoListItem extends Component {

  handleRemoveTodo = () => {
    this.props.onRemoveTodo(this.props.todo.id);
  }

  handleToggleCompleted = () => {
    this.props.onToggleCompleted(this.props.todo.id);
  }

  render() {
    return (
      <li>
        <span
          onClick={ this.handleToggleCompleted }
          className={ this.props.todo.completed ? 'TodoListItem-completed' : '' }
        >
          { this.props.todo.content }
        </span>
        <button onClick={ this.handleRemoveTodo }>X</button>
      </li>
    )
  }
}

TodoListItem.propTypes = {
  onRemoveTodo: React.PropTypes.func.isRequired,
  onToggleCompleted: React.PropTypes.func.isRequired,
  todo: React.PropTypes.shape({
    content: React.PropTypes.string.isRequired,
    completed: React.PropTypes.bool.isRequired,
    id: React.PropTypes.number.isRequired
  }).isRequired
}

export default TodoListItem;
