


const currentUser = (state = {}, action) =>{
  switch (action.type) {
    case 'GETUSER':
      const newState = {...state}
      newState.currentUser = action.user;
      console.log('in da newState' , newState);
      return newState;
    default:
      return state;
  }
}


export default currentUser;
