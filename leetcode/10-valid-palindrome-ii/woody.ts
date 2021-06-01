const checkPalindrome = (str, start, end, isDeletable) => {
  if (start === end || start > end) {
    return true
  }

  const startChar = str.charAt(start)
  const endChar = str.charAt(end)

  if (startChar === endChar) {
    return checkPalindrome(str, start + 1, end - 1, isDeletable)
  }

  if (startChar !== endChar) {
    if (isDeletable) {
      return checkPalindrome(str, start, end - 1, false) || checkPalindrome(str, start + 1, end, false)
    }

    return false
  }
}

function validPalindrome(s: string): boolean {
  return checkPalindrome(s, 0, s.length - 1, true)
}
