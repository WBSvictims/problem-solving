function isValidSudoku(board: string[][]): boolean {
  const row = new Set<string>()
  const column = new Set<string>()
  const subbox = new Set<string>()

  for (let i = 0; i < 9; i++) {
    for (let j = 0; j < 9; j++) {
      const v = board[i][j]

      if (v === '.') {
        continue
      }

      const rowKey = `${i}-${v}`
      const columnKey = `${j}-${v}`
      const subboxKey = `${Math.floor(i / 3)}-${Math.floor(j / 3)}-${v}`

      if (row.has(rowKey)) return false
      if (column.has(columnKey)) return false
      if (subbox.has(subboxKey)) return false

      row.add(rowKey)
      column.add(columnKey)
      subbox.add(subboxKey)
    }
  }


  return true
}
