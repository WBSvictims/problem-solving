function search(nums: number[], target: number): number {
  let result = -1
  let min = 0
  let max = nums.length - 1

  while (min <= max) {
    const mid = Math.floor((min + max) / 2)

    if (nums[mid] === target) return mid
    if (nums[min] === target) return min
    if (nums[max] === target) return max

    if (nums[mid] < target) {
      if (nums[min] < target && nums[mid] < nums[min]) {
        max = mid - 1
      } else {
        min = mid + 1
      }
    }

    if (nums[mid] > target) {
      if (nums[max] > target && nums[mid] > nums[max]) {
        min = mid + 1
      } else {
        max = mid - 1
      }
    }
  }

  return -1
}
