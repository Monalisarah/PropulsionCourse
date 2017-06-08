import React, { Component } from 'react';


class TodoItem extends Component {

  handleClick = () => {
  console.log('you clicked the element!');
  console.log(this)
}
  render(){
    console.log(this.props);

    return(
      <li onClick ={this.handleClick}>{this.props.todo}</li>
    )
  }
}

export default TodoItem;
