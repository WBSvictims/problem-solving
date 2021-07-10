function isPowerOfThree(n: number): boolean {
  if (n === 1) {
    return true
  }

  if (n < 1) {
    return false
  }

  return isPowerOfThree(n / 3)
}
