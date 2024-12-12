/**
 * @param {Function} fn
 */
function memoize(fn) {
    let mp = new Map();
    return function newfn(...params){       
        if(mp.has(JSON.stringify(params))){
            return mp.get(JSON.stringify(params));
        }
         let res = fn(params[0],params[1]);
        mp.set(JSON.stringify(params),res);
        return res;
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */