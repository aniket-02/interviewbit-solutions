public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode temp = head;

        while (temp != null) {
            RandomListNode node = new RandomListNode(temp.label);
            map.put(temp, node);
            temp = temp.next;
        }
        
        temp = head;

        while (temp != null) {
            RandomListNode node = map.get(temp);
            node.next = map.get(temp.next);
            node.random = map.get(temp.random);
            temp = temp.next;
        }
        
        return map.get(head);
    }
}
