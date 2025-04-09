package com.test.begin2.di9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/*
 * @Component public class Service { private Hong hong;
 * 
 * //의존 주입 도구에 @Autowired를 선언 //- Spring 2.5부터 지원됨(오래됨)
 * 
 * @Autowired public Service(Hong hong) { this.hong = hong; }
 * 
 * public void use() { hong.work(); } }
 */





/*
 * @Component public class Service { private Hong hong;
 *
 *setter에 @Autowired 선언 
 * @Autowired public void setHong(Hong hong) { this.hong=hong; }
 * 
 * public void use() { hong.work(); } }
 */




/*
 * @Component public class Service { //멤버 변수에 직접 @Autowired 선언 //- 의존 주입 도구(생성자,
 * Setter)가 필요 ㅓㅇㅄ다. //- 가장 단순한 방법 //- 테스트와 유지보수가 어렵다.
 * 
 * @Autowired private Hong hong;
 * 
 * 
 * public void use() { hong.work(); } }
 */





/*
 * @Component public class Service {
 * 
 * private Hong hong;
 * 
 * //생성자가 1개라면 별도의 선언 없이 의존 주입이 발생 //spring 4.3 //생성자가 2개 이상이면 의존 주입에 사용할
 * 생성자에 @Autowired를 선언해야한다.
 * 
 * @Autowired public Service(Hong hong) { this.hong=hong; }
 * 
 * //생성자 2개일때는 @Autowired 써야함 public Service(Hong hong, int num) {
 * 
 * }
 * 
 * public void use() { hong.work(); } }
 */










/*
 * @Component public class Service {
 * 
 * private Hong hong;
 * 
 * //가장 추천되는 방법 //생성자가 1개라면 별도의 선언 없이(@Autowired 생략) 의존 주입이 발생 //spring 4.3
 * public Service(Hong hong) { this.hong=hong; }
 * 
 * public void use() { hong.work(); } }
 */


/*
 * @Component public class Service {
 * 
 * private Hong hong;
 * 
 * //생성자일때는 @Autowired생략 가능하지만 //Setter는 생략 불가능
 * 
 * @Autowired public void setHong(Hong hong) { this.hong=hong; }
 * 
 * public void use() { hong.work(); } }
 */


/*
 * //lombok을 사용 + Setter 사용
 * 
 * @Component
 * 
 * @Setter //setter위에 autowired안붙어서 안됨 public class Service {
 * 
 * private Hong hong;
 * 
 * 
 * public void use() { hong.work(); } }
 */




/*
 * //lombok을 사용 + Setter 사용
 * 
 * @Component public class Service {
 * 
 * @Setter(onMethod_ = @Autowired) private Hong hong;
 * 
 * 
 * public void use() { hong.work(); } }
 */


/*
 * //lombok을 사용 + 생성자 사용
 * 
 * @Component 
 * //@NoArgsConstructor 
 * //인자가 없는 default constructor(생성자) 만들어주셈
 * 
 * @AllArgsConstructor 
 * //모든 멤버 변수를 인자로 가지는 생성자 만들어주셈 
 * 
 * //@RequiredArgsConstructor
 * //선택적으로 인자를 가가지는 생성자 
 * 
 * public class Service {
 * 
 * 		private Hong hong;
 * 
 * 		//@Autowired 
 * 		//public Service(Hong hong) { 
 * 		// this.hong=hong; 
 * 		//}
 * 
 * 
 * 		public void use() { 
 * 			hong.work(); 
 * 		} 
 * }
 */



//lombok을 사용 + 생성자 사용
@Component
@AllArgsConstructor //모든 멤버 변수를 인자로 가지는 생성자 만들어주셈
public class Service {
	
	private Hong hong;
	
	public void use() {
		hong.work();
	}
}









