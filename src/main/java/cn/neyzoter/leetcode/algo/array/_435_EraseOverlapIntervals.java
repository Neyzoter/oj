package cn.neyzoter.leetcode.algo.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * 435. 无重叠区间
 * @author Charles Song
 * @date 2020-6-15
 */
public class _435_EraseOverlapIntervals {
    public static void main (String[] args) {
        int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};
        Sol1_EraseOverlapIntervals sol = new Sol1_EraseOverlapIntervals();
        System.out.println (sol.eraseOverlapIntervals(intervals));
    }
}

class Sol1_EraseOverlapIntervals {
    class Range {
        int left;
        int right;
        Range (int l, int r) {
            left = l;
            right = r;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        ArrayList<Range> ranges = new ArrayList<>();
        for (int i = 0; i < intervals.length; i ++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            ranges.add(new Range(l, r));
        }
        ranges.sort(new Comparator<Range>() {
            @Override
            public int compare(Range o1, Range o2) {
                return o1.right - o2.right;
            }
        });
        int num = 0;
        for (; ranges.size() > 0; ) {
            Range range = ranges.get(0);
            Iterator<Range> iter = ranges.iterator();
            for (; iter.hasNext(); ) {
                Range r = iter.next();
                if (!valid(r, range)) {
                    iter.remove();
                    if (!r.equals(range)) {
                        num ++;
                    }
                }
            }
        }

        return num;
    }

    public boolean valid (Range r1, Range r2) {
        if (r1.left >= r2.right || r1.right <= r2.left) {
            return true;
        }
        return false;
    }
}
