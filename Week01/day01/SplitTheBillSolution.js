splitTheBill = function(obj) {
  let total = 0;
  for (let i in obj) {
    total += obj[i];
  }
  for (let i in obj) {
    obj[i] = -(obj[i] - total/(Object.keys(obj).length));
  }

  return obj;
}
