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
// var isEmpty=function(obj){
//     if(Object.keys(obj).length===0){
//         return true;
//     }
//     else{
//         return false;
//     }
// };


const isEmpty = function(obj) {
    if (obj === null) return true; 

    if (Array.isArray(obj)) return obj.length === 0; 

    if (typeof obj === "object") return Object.keys(obj).length === 0;

    return false
};