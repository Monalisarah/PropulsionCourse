

const feedReducer = (state = {}, action) =>{
  switch (action.type) {
    case 'GETFEED':
      const newState = Object.assign({}, state, action.feed);
      console.log('in da newState' , newState);
      return newState;
    default:
      return state;
  }
}


export default feedReducer;
