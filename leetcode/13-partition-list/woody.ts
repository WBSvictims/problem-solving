/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function partition(head: ListNode | null, x: number): ListNode | null {
  let less = new ListNode()
  let greater = new ListNode()
  let h = head
  let l = less
  let g = greater

  while (h) {
    if (h.val < x) {
      l = l.next = h
    } else {
      g = g.next = h
    }
    h = h.next
  }

  l.next = greater.next
  g.next = null

  return less.next

}
