/*
Problem-
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] 
(si < ei), determine if a person could attend all meetings. For example, Given [[0, 30],[5, 10],[15, 20]], return false.
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
		System.out.println(i.canAttendMeetings(i.createIntervals()));
	}
	
	public boolean canAttendMeetings(Interval[] intervals) {
		//sort by start time and check for overlap, if overlap, return false
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		
		//check overlap
		for(int i = 1; i < intervals.length; i++) {
			if(intervals[i - 1].end > intervals[i].start)
				return false;
		}
		
		return true;
	}
	
	public Interval[] createIntervals() {
		return new Interval[] {new Interval(0, 3), new Interval(5, 10), new Interval(61, 100), 
								new Interval(15, 20), new Interval(20, 60)/*, new Interval(0, 5)*/};
	}
}