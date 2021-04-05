function maxDepth(root) {
  if (!root.children.length) {
    return 1
  }
  
  const depthList = root.children.map((n) => maxDepth(n) + 1)

  return Math.max(...depthList)
}
