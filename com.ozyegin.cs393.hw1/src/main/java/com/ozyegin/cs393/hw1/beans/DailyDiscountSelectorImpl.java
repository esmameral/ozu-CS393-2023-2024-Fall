package com.ozyegin.cs393.hw1.beans;

import org.springframework.stereotype.Component;

@Component
public class DailyDiscountSelectorImpl implements DailyDiscountSelector {

	@Override
	public int getDailyDiscountRate() {
		int random = (int) (Math.random() * 4 + 1);
		switch (random) {
		case 1: {
			return 15;
		}
		case 2: {
			return 20;
		}
		case 3: {
			return 25;
		}
		case 4: {
			return 30;
		}
		default:
			return 0;
		}
	}
}
