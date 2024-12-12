/**
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
var addTwoPromises = async function(promise1, promise2) {
    try{
        const results = await Promise.all([promise1, promise2]);
        return results.reduce((accumulator, currentValue) => accumulator + currentValue, 0);
    } catch(error) {
        throw new Error(`Parent rejected due to ${error}`)
    }
}; 

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */