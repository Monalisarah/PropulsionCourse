import React, { Component } from 'react';

import TodoListItem from '../TodoListItem';
import './index.css';

class TodoList extends Component {

  render() {
    return (
      <div className="TodoList">
        <ul>
          {
            this.props.todos.map((todo, index) =>
              <TodoListItem
                key={ todo.id }
                todo={ todo }
                onRemoveTodo={ this.props.onRemoveTodo }
                onToggleCompleted={ this.props.onToggleCompleted }
              />
            )
          }
        </ul>
      </div>
    );
  }
}

TodoList.propTypes = {
  onToggleCompleted: React.PropTypes.func.isRequired,
  onRemoveTodo: React.PropTypes.func.isRequired,
  todos: React.PropTypes.array
}

export default TodoList
