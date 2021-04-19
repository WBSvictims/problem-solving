function canJump(nums: number[]): boolean {
  let maxIndex = 0
  let result = true

  for (let i = 0, l = nums.length; i < l; i++) {
    if (i > maxIndex) {
      result = false
      break
    }

    maxIndex = Math.max(i + nums[i], maxIndex)
  }

  return result
}
