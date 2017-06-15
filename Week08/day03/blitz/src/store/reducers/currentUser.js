


const currentUser = (state = {}, action) =>{
  switch (action.type) {
    case 'GETUSER':
      //const newState = {...state}
      // add new property to the newState (which is an empty object)
      //newState.currentUser = action.user; -> this does not work!
      const newState = Object.assign({}, state, action.user);
      // console.log('in da newState' , newState);
      return newState;
    default:
      return state;
  }
}


export default currentUser;
