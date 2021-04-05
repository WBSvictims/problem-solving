function minAddToMakeValid(S) {
  const result = []
  
  for (let i = 0, l = S.length; i < l; i++) {
    if (S[i] === '(') {
      result.push(S[i])
    } else if (result[result.length - 1] === '(') {
      result.pop()
    } else {
      result.push(S[i])
    }
  }
  
  return result.length
}
