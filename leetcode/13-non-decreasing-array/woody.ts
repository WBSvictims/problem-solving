function checkPossibility(nums: number[]): boolean {
  let result = false
  let modified = false

  for (let i = 0; i < nums.length - 1; i++) {
    if (nums[i] > nums[i + 1]) {
      if (modified) {
        return false
      }

      if (i > 0 && nums[i - 1] > nums[i + 1]) {
        nums[i + 1] = nums[i] + 1
      } else {
        nums[i] = nums[i + 1] - 1
      }

      modified = true
    }
  }

  return true
}
