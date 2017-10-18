package session1;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.testng.annotations.*;


public class Test1 {
	
/* Primero los DataProviders */
	
  @DataProvider(name = "Mult")
  public Object[][] Multiplier() {
  return new Object[][] {
		{ new Integer(1), new Integer(2) },
		{ new Integer(3), new Integer(4) },
		{ new Integer(5), new Integer(6) }
		};
  }

  @DataProvider(name = "Concat")
  public Object[][] Concat() {
  return new Object[][] {
		{ new String("Word1"), new String("Word2"), new String("Word3") },
		{ new String("Word4"), new String("Word5"), new String("Word6") },
		{ new String("Word7"), new String("Word8"), new String("Word9") },
		{ new String("Word10"), new String("Word11"), new String("Word12") }
		};
  }

  @DataProvider(name = "Ambiente")
  public Object[][] Ambiente() {
  return new Object[][] {
		{ new String("AMBIENTE1"), new Integer(26), new Integer(15) },
		{ new String("AMBIENTE2"), new Integer(42), new Integer(9) },
		};
  }
  
  /* Segundo los Tests */
  
  @Test (dataProvider="Mult",groups = {"Smoke" , "Regression"} )
   public void Test1(Integer mult1, Integer mult2) {
	  System.out.println("Resultado: " + mult1*mult2);
  }
  
  @Test (dataProvider="Concat", groups = {"Smoke" , "Regression"})
  public void Test2(String a, String b, String c) {
	  System.out.println(a+b+c);
  }
  

  
  @Test (groups = {"Smoke"})
  @Parameters({"TestDate"}) 
  public void Test3(String TestDate) throws ParseException {
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	  java.util.Date date = sdf.parse(TestDate);
	 String stringdate=sdf.format(date);
	 System.out.println(stringdate);
  }
  
  @Test (dataProvider="Ambiente",groups = {"Smoke"})
  public void Test4(String ambiente, int a, int b) {
	  int result;
	  if(ambiente.equals("AMBIENTE1")) {
		  result=a*b;
	  }else {
	  if (ambiente.equals("AMBIENTE2")) {
		  result=a-b;
	  }
	  else {
		  result=0;
	  }}
	  System.out.println(ambiente +" "+a+" "+b+" "+result);
  }
  
  /* Tercero las anotaciones */
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite");
  }

  @BeforeGroups
  public void BeforeGroups() {
	  System.out.println("Before Groups");
  }
  
  @AfterGroups
  public void AfterGroups() {
	  System.out.println("After Groups");
	  
  }
  
}
