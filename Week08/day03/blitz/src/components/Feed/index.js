import React, {Component} from 'react';
import {connect} from 'react-redux';
import {getFeed} from '../../store/actions.js';
import FeedItem from '../FeedItem';


class Feed extends Component {

  componentDidMount = (e) => {
    // console.log('in da componentDidMount');
    const feed = this.props.dispatch(getFeed());
  }

    render() {
      // console.log('in da Feed', this.props.feeds);
      return (
        <div>
            Feeds:
            <ul>
              {
                this.props.feeds.map((blitz) => {
                  return <FeedItem
                    key={blitz._id}
                    blitz={blitz.content}
                    user={blitz._user.username}/>
                })
              }
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
