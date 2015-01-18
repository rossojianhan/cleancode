package BinarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 1/14/15.
 */
public class FindMinimuminRotatedSortedArrayII {


    @Test
    public void findMin() {
        int[] a = {1, 2, 2, 3};
        int[] a1 = {2, 1, 1};
        int[] a2 = {5, 1, 5, 5,5,5};
        int[] a3 = {3, 3, 1, 3};
        int e = findMin(a3);
        int d = findMin(a2);
        int c = findMin(a1);
        int b = findMin(a);
        assertEquals("failure - findMin  of '3313' not right", 1, e);
        assertEquals("failure - findMin  of '515555' not right", 1, d);
        assertEquals("failure - findMin  of '2, 1,1' not right", 1, c);
        assertEquals("failure - findMin  of '1, 2,2, 3' not right", 1, b);
    }

    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }

        if (num.length == 2) {
            return num[0] < num[1] ? num[0] : num[1];
        }

        int l = 0;
        int r = num.length - 1;
        while(l < r && num[l] >= num[r]) {
            int m = l + (r - l) / 2;
            if (num[m] > num[r]) {
                l = m + 1;
            } else if (num[m] < num[l]) {
                r = m;
            } else {
                l = l + 1;
            }
        }
        return num[l];
    }
}
