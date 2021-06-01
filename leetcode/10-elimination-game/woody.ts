// const remove = (arr) => {
//   if (arr.length === 1) {
//     return arr[0]
//   }

//   const result = []

//   for (let i = 1, l = arr.length; i < l; i = i + 2) {
//     result.push(arr[i])
//   }

//   return remove(result.reverse())
// }

// function lastRemaining(n: number): number {
//   const arr = Array.from({ length: n }, (item, index) => index + 1)
//   return remove(arr)
// }

const isOdd = (n) => n % 2 === 1

function lastRemaining(n: number): number {
  let min = 1
  let max = n
  let left = false
  let offset = 1
  let size = n

  while (max > min) {
    if (left) {
      max -= offset
      if (isOdd(size)) min += offset
    } else {
      min += offset
      if (isOdd(size)) max -= offset
    }

    size = Math.floor(size / 2)
    offset = offset * 2
    left = !left
  }

  return min
}
