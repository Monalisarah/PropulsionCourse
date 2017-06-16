import React, {Component} from 'react';
import { Link } from 'react-router-dom';



class FeedItem extends Component{
  render(){
    // console.log("feeditem: ", this.props);
    return(
      <div style={{marginBottom: 10}}>
        <li> {this.props.blitz} </li>
        <Link to="/users/:userId"> {this.props.user}</Link>
      </div>

    );
  }
}



  export default FeedItem;
