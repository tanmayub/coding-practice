/*
Problem-
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] 
find the minimum number of conference rooms required
*/

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	class Interval {
		int start, end;
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Ideone i = new Ideone();
		System.out.println(i.minMeetingRooms(i.createIntervals()));
	}
	
	public int minMeetingRooms(Interval[] intervals) {
		if(intervals.length <= 0)
			return 0;
			
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		//min heap to sort by earliest finish time
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(intervals[0].end);
		int ct = 1;
		
		for(int i = 1; i < intervals.length; i++) {
			//if current event starts before pqriotirty queue top end, need extra room
			//else we dont need extra room -- at the end add interval.end to priorityqueue(min heap)
			if(intervals[i].start < pq.peek())
				ct++;
			else
				pq.poll();
			pq.offer(intervals[i].end);
		}
		
		return ct;
	}
	
	public Interval[] createIntervals() {
		return new Interval[] {new Interval(0, 3), new Interval(5, 10), new Interval(61, 100), new Interval(15, 20), new Interval(20, 60), new Interval(0, 5)};
	}
}