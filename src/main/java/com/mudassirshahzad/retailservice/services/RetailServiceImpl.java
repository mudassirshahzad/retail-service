/**
 * 
 */
package com.mudassirshahzad.retailservice.services;

import com.mudassirshahzad.retailservice.entities.Item;
import com.mudassirshahzad.retailservice.entities.ItemType;
import com.mudassirshahzad.retailservice.entities.User;
import com.mudassirshahzad.retailservice.entities.UserType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import lombok.AllArgsConstructor;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Service;

/**
 * @author Mudassir Shahzad Dec 27, 2019
 */
@Service
@AllArgsConstructor
public class RetailServiceImpl implements RetailService {

	ConfigurableEnvironment env;

	@Override
	public double calculateTotal(User user, List<Item> items) {

		// 1 - Calculate discount percentage based on user type
		float discountPercentage = getDiscountPercentage(user);

		// 2 - Calculate total amount of the discountable items
		double userDiscountableAmount = getTotalAmountWithoutGroceries(items);

		// 3 - Check total bill amount for extra discount
		Long moreDiscountOn = Long.parseLong(env.getProperty("discount.on.every"));
		double extraDiscount = 0d;
		double totalAmount = 0d;
		if (userDiscountableAmount >= moreDiscountOn) {

			totalAmount = items.stream().mapToDouble(Item::getPrice).sum();
			extraDiscount = getExtraDiscount(totalAmount, moreDiscountOn);
		}

		// 3 - Apply the user discount
		double userDiscount = getUserDiscount(userDiscountableAmount, discountPercentage);

		return getFinalBillAmount(totalAmount, extraDiscount, userDiscount);
	}

	@Override
	public float getDiscountPercentage(User user) {

		if (UserType.EMPLOYEE.equals(user.getUserType())) {
			return Float.parseFloat(env.getProperty("discount.employee.percentage"));
		} else if (UserType.AFFILIATE.equals(user.getUserType())) {

			return Float.parseFloat(env.getProperty("discount.affiliate.percentage"));
		} else if (UserType.REGULAR_CUSTOMER.equals(user.getUserType())) {

			return Float.parseFloat(env.getProperty("discount.regular.customer.percentage"));
		} else {

			return Float.parseFloat(env.getProperty("discount.new.customer.percentage"));
		}
	}

	@Override
	public double getTotalAmountWithoutGroceries(List<Item> items) {

		return items.stream().filter(item -> item.getPrice() != 0L && item.getType() != ItemType.GROCERY)
				.mapToDouble(Item::getPrice).sum();
	}

	@Override
	public double getUserDiscount(double totalAmount, float discountPercentage) {

		double userDiscount = (totalAmount * (discountPercentage / 100.0f));
		BigDecimal roundedUserDiscount = BigDecimal.valueOf(userDiscount).setScale(2, RoundingMode.HALF_UP);
		return roundedUserDiscount.doubleValue();
	}

	@Override
	public double getFinalBillAmount(double userDiscountableAmount, double extraDiscount, double userDiscount) {
		return (userDiscountableAmount - userDiscount) - extraDiscount;
	}

	@Override
	public double getExtraDiscount(double totalAmount, Long moreDiscountOn) {

		double discountAmount = Double.parseDouble(env.getProperty("discount.amount"));
		int numerOfTimes = (int) (totalAmount / moreDiscountOn);
		return discountAmount * numerOfTimes;

	}

}
