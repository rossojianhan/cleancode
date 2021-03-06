package linkedList;

import java.util.HashMap;
import java.util.Map;

import com.sun.jndi.url.dns.dnsURLContext;
import org.junit.Test;

/**
 * Created by jiahan on 12/23/14.
 */
public class CopyListwithRandomPointer {
    @Test
    public void copyRandomList() {
        RandomListNode l1 = new RandomListNode(-1);
        RandomListNode l2 = new RandomListNode(-1);
        l1.next = l2;
        l1.random = l2;
        l2.random = l1;

        RandomListNode r = copyRandomList(l1);
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map2 = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode source = head;
        RandomListNode current = dummy;

        while (source != null) {
            RandomListNode newNode = new RandomListNode(source.label);
            newNode.random = source.random;
            current.next = newNode;
            map2.put(source, newNode);
            current = current.next;
            source = source.next;
        }
        current = dummy.next;
        while (current != null) {
            current.random = map2.get(current.random);
            current = current.next;
        }
        return dummy.next;
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }

    private void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }

    private void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.next.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    private RandomListNode splitList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(-1);
        dummy.next = head;
        RandomListNode current = dummy;
        while (head != null) {
            current.next = head.next;
            current = current.next;
            if (head.next != null) {
                head.next = head.next.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
