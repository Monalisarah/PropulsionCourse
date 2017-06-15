import React, {Component} from 'react';
import {connect} from 'react-redux';
import {getFeed} from '../../store/actions.js';


class Feed extends Component {
    render() {
      console.log(this.props);
      return (
       <div>HellofromFeed</div>
      );
    }
  }





export default connect()(Feed);
