function removeDuplicates(str) {
  const result = []
  
  for (let i = 0, l = str.length; i < l; i++) {
    if (str[i] === result[result.length - 1]) {
      result.pop()
    } else {
      result.push(str[i])
    }
  }
  
  return result.join('')
}
