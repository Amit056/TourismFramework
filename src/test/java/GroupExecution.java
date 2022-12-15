import org.testng.annotations.Test;
public class GroupExecution {
	
@Test()
public void test()
{
	System.out.println("test");
	System.out.println(Thread.currentThread().getId());
	}
@Test()
public void test1()
{
	System.out.println("test1");
	System.out.println(Thread.currentThread().getId());
	}
@Test()
public void test2()
{
	System.out.println("test2");
	System.out.println(Thread.currentThread().getId());
	}
@Test()
public void test3()
{
	System.out.println();
	System.out.println(Thread.currentThread().getId());
	}
}
