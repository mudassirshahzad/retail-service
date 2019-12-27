/**
 * 
 */
package com.mudassirshahzad.retailservice.services;

import com.mudassirshahzad.retailservice.entities.Item;
import com.mudassirshahzad.retailservice.entities.User;

import java.util.List;

/**
 * @author Mudassir Shahzad Dec 27, 2019
 */
public interface RetailService {

	float getDiscountPercentage(User user);

	double getTotalAmountWithoutGroceries(List<Item> items);

	double getUserDiscount(double totalAmount, float discountPercentage);

	double getFinalBillAmount(double userDiscountableAmount, double extraDiscount, double userDiscount);

	double getExtraDiscount(double totalAmount, Long moreDiscountOn);

	double calculateTotal(User user, List<Item> items);
}
