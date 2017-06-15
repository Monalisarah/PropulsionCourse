import React, {Component} from 'react';
import {connect} from 'react-redux';


class Result extends Component {
  render (){
    return <div>Your result is ${this.props.result}</div>

  }
}

//important : in the second parameter is the props so far where the information of the router is
const mapStateToProps = (state, props)  => {
  console.log(props.match.params.order);
  return {
    result: state.result
  }
})





export default connect (mapStateToProps)(Result)
