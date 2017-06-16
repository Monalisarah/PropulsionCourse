import React, {Component} from 'react';
import {connect} from 'react-redux';
import {getFeed} from '../../store/actions.js';


class Feed extends Component {

  componentDidMount = (e) => {
    // console.log('in da componentDidMount');
    const feed = this.props.dispatch(getFeed());
  }

    render() {
      // console.log('in da Feed', this.props.feed);
      return (
        <div>
            HellofromFeed
            <ul>
              {this.props.feeds.map((element, index) => {
                return <li key= {index}>{element.content}</li>
              })}
            </ul>
       </div>
      );
    }
  }


const mapStateToProps = (state) => {
  // console.log('in da map satee to props', feeds);
  return {
    feeds: state.feedReducer
  }
}


export default connect(mapStateToProps)(Feed);
