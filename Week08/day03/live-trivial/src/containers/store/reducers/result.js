export default result = (state = 0, action) =>{
  switch (action.type) {
    case 'addResult':
    return action.isCorrect ? state +1  .....
    default:
    return state;

  }
  return state;
}
