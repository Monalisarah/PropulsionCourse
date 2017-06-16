
// first day steps:
// fake19@email.com
//fake2@email.com
// password
// do the fetch
// method: POST
// body: send email and password, with JSON.stringify
// header -> 'Content-Type': 'application/json'
// res.json()
// recieve a user
// store this user in redux state:
// create an action
// dispatch the action
// handle the action in the reducer


// 2.Day steps:
// add 1 mor Route (Feed) component for that Route
// get the hello in the new page /Feed
// redirect the user to /feed after loginUser
// Fetch the feed in the component
// this.props.history push in the new Component

//3.Day steps
// in actions.js:
// create and dispatch an action inside the getFeed

// in da Reducer:
// create new feedReducer
// handle the action

//change that no need for new login after the request

//for each of the blitzes add an user
//display username before tweet
//after click on the user go there --> create a link (react router notes, import { Link } from router)

// create FeedItem element
// return <FeedItem key={blitz.id} blitz={ blitz } />

// remove:
//
// {this.props.feeds.map((element, index) => {
//   return <li key= {index}>{element.content}<br></br> {' by : '} {element._user.username}</li>
// })}
//
// <div>
//       HellofromFeed
//       <ul>
//         {this.props.feeds.map((blitz) => {
//           return <li key={blitz._id}>{blitz.content}<br></br>{' By: '}{blitz._user.username}</li>
//         })}
//       </ul>
//     </div>

// in the FeedItem use Link for the username
