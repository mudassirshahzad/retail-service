/**
 * 
 */
package com.mudassirshahzad.retailservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mudassir Shahzad Dec 27, 2019
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private UserType userType;

}
