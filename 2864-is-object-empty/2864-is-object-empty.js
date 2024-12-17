/**
 * @param {Object|Array} obj
 * @return {boolean}
 */
// var isEmpty = function(obj) {
//     for(let key in obj){
//         return false;
//     }
//     return true;
// };

// using Object.keys
var isEmpty=function(obj){
    if(Object.keys(obj).length===0){
        return true;
    }
    else{
        return false;
    }
};