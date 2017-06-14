import React, { Component} from 'react';
import PropTypes from 'prop-types';


class TodoItem extends Component {

handleClick = () => {
    console.log('you clicked the element!');
    console.log(this)
  }

render() {
  console.log(this.props);
  return <li onClick = {this.handleClick} > {this.props.todo} < /li>
  }
}

TodoItem.propTypes = {
  todo: PropTypes.string
};

export default TodoItem;
