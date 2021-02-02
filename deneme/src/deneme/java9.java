package deneme;

interface myInterfaca{
	int a = 100;
	void sayName();
}
public class java9 implements myInterfaca {
	
	public static void main(String[] args) {
		java9 obj = new java9();
		obj.sayName();
		
		System.out.println( myInterfaca.a);
		
	}

	@Override
	public void sayName() {
		// TODO Auto-generated method stub
		
		System.out.println( this.a);
	}
}
