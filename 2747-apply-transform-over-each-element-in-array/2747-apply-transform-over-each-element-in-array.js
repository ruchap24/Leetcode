/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    var newArr=[];  
  for(var i in arr)
    {             
      newArr.push(fn(arr[i],parseInt(i)));
    } 
  return newArr;
};