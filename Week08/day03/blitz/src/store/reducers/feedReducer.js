

const feedReducer = (state = [], action) =>{
  switch (action.type) {
    case 'GETFEED':
      const newState = [...action.feeds]
      // console.log('in da newState',newState);
      return newState;
    default:
      return state;
  }
}


export default feedReducer;
