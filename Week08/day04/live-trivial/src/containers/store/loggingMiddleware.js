//6. make our own middleware (thunk is a middleware)


const middleware = (store) => (next) => (action) =>{
  console.log('in da middleware');
  console.log(action);
  return next(action)
}


export default middleware;
