package com.test.begin2.di9;

import org.springframework.stereotype.Component;

//<bean class="com.test.begin2.di9.Hong"></bean>
@Component
public class Hong {
	public void work() {
		System.out.println("업무를 진행합니다.");
	}

}
