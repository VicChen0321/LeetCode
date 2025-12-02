# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        h = []
        heapq.heapify(h)

        for i, node in enumerate(lists):
            if node:
                heapq.heappush(h, (node.val, i, node))
        
        dummy = ListNode(0)
        cur = dummy

        while h:
            val, i, node = heapq.heappop(h)
            cur.next = node
            cur = cur.next
            
            if node.next:
                node = node.next
                heapq.heappush(h, (node.val, i, node))
        
        return dummy.next
