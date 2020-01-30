package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Messenger;

public class MainClass2 {
	public static void main(String[] args) {
		// init.xml 문서를 로딩해서 bean 으로 만들것들은 만들어서 관리 한다.
		ApplicationContext context=
			new ClassPathXmlApplicationContext("test/main/init.xml");
		Messenger m=context.getBean(Messenger.class);
		m.sendGreeting("좋은 아침~");
		m.sendGreeting("바보야! 좋은 아침~");
	}
}










