package com.techolution;

public class BuyingShowTickets {

	public static void main(String[] args) {
		int n = 5;
		int[] tickets = {2,6,3,4,5};
		int p = 2;
		System.out.println(waitingTime(tickets, p));
	}

	static long waitingTime(int[] tickets, int p) {
		int ticketNeeded = tickets[p];
		long res = 0L;
		int n = tickets.length;
		long time=0;
		if (ticketNeeded > 1) {
			while (res < ((long) ticketNeeded-1)) {
				int min = Integer.MAX_VALUE;
				int cnt = 0, pos = -1;
				for (int i = 0; i < n; i++) {
					if (tickets[i] <= 0)
						continue;
					if (min > tickets[i]) {
						min = tickets[i];
						pos = i;
					}
					cnt++;
				}
				res+=min;
				if (pos >= 0)
					tickets[pos] = -1;
				time = time + cnt * min;
				
			}
		} 
		int pos = 0;
		for (int i = 0; i < p; i++) {
			if (tickets[i] < 0)
				continue;
			pos++;
		}
		return time + (long) pos+1;
	}
}
