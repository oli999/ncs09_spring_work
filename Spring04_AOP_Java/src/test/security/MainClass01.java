package test.security;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass01 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("문자열 입력:");
		String str=scan.nextLine();
		//문자열을 암호화 해주는 객체 생성 
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		//입력한 문자열을 암호화 한다.
		String result=encoder.encode(str);
		System.out.println("입력한 문자:"+str);
		System.out.println("암호화된 문자:"+result);
	}
}












