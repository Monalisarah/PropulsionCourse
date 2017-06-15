import React, {Component} from 'react';

class Feed extends Component{

  componentDidMount(){
    this.props.dispatch (fetchFeed())
  }

  render()
  return <div>Hello</div>
}


export default connect() (Feed);
