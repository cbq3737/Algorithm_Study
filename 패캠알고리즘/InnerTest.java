package ch01;

class OutClass{
		private int num= 10;
		private static int sNum = 20;
		private InClass inClass;
		public OutClass() { //외부 클래스가 생성될 때 내부 클래스를 생성해준다.
			inClass= new InClass();//여기서 생성
		}
		
		private class InClass{ //얘가 내부 클래스,private으로 선언
			int iNum = 100;
			
			void inTest() {
				System.out.println("OutClass num = "+ num +"(외부 클래스의 인스턴스 변수");
				System.out.println("OutClass sNum = "+ sNum +"(외부 클래스의 static 변수");
				System.out.println("InClass iNum = "+ iNum +"(내부 클래스의 인스턴스 변수");
			}
		}
		public void usingClass() {
			inClass.inTest();
		}
		
		static class InStaticClass {
			int iNum =100;
			static int sInNum = 200;
		
			void inTest() {
				//정적클래스의 메서드는 외부클래스의 인스턴스변수를 사용할 수 없다.->정적 클래스는 외부 클래스와 무관하게 사용될 수 있으므로
				//대신에 본인의 인스턴스변수를 사용하는건 상관이없다.
			//  System.out.println("OutClass num = "+ num +"(외부 클래스의 인스턴스 변수");
				System.out.println("InClass num = "+ iNum +"(내부 클래스의 인스턴스 변수");
				System.out.println("OutClass sNum = "+ sNum +"(외부 클래스의 static 변수");
				System.out.println("InClass iNum = "+ sInNum +"(내부 클래스의 static 변수");
			//외부 클래스의 인스턴스 변수는 못쓴다 -> 생성이 안되었을 수도 있기 때문에
			}
			static void sTest() { //여기서는 내부 클래스의 인스턴스 변수를 못쓴다. 정적 클래스의 정적 메서드는 정적클래스가 생성이되지않아도 호출될 수 있기때문에,그때는 변수가 생성이 안되어있을 수도 있으므로 
			//	System.out.println("InClass num = "+ iNum +"(내부 클래스의 인스턴스 변수");
				System.out.println("OutClass sNum = "+ sNum +"(외부 클래스의 static 변수");
				System.out.println("InClass iNum = "+ sInNum +"(내부 클래스의 static 변수");
			}
		}
}

public class InnerTest {

	public static void main(String[] args) {
//		OutClass outclass =new OutClass();
//		outclass.usingClass();
		//private없을 시 -> 이렇게 많이 사용하진 않는다. 문법적으로 가능
//		OutClass.InClass inner = outclass.new InClass();
//		inner.inTest();
		
		//이렇게 인스턴스와 다르게 외부클래스에서 바로 정적클래스 생성가능
		OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
		sInClass.inTest();//일반메서드
		System.out.println();
		
		//이렇게 바로 호출이 가능
		OutClass.InStaticClass.sTest(); //static변수들만 쓸 수 있다.
		
	}
}
