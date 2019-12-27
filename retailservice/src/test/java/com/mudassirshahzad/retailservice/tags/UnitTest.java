package com.mudassirshahzad.retailservice.tags;

import com.emirates.bff.trips.Application;

/*-
 * #%L
 * groundContent
 * %%
 * Copyright (C) 2018 Emirates Group IT
 * %%
 * This file is part of Mobile Channels BFF.
 *
 * Mobile Channels BFF can not be copied and/or distributed without the express
 * permission of Emirates Group IT
 * #L%
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Tag("UnitTest")
@SpringBootTest(classes = Application.class)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("eclipse")
@TestPropertySource(locations = "classpath:test.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public @interface UnitTest {
}
