import React, {Component} from 'react';
import {connect} from 'react-redux';
import {getFeed} from '../../store/actions.js';


class Feed extends Component {

  componentDidMount = (e) => {
    console.log('in da componentDidMount');
    const feed = this.props.dispatch(getFeed());
  }

    render() {
      console.log(this.props);
      return (
        <div>
          <div>HellofromFeed</div>
       </div>
      );
    }
  }





export default connect()(Feed);
