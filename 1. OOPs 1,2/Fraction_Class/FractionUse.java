package Fraction_Class;


public class FractionUse {
  // public static void temp() throws zeroDenominatorException{  if we just want to throw exception *jo jo function exception catch nhi karta usko ese karna hoga
   // agar exception kahi bhi catch nhi hoga toh last me user ke paas pohch jaayega. to paas we use this
   public static void temp(){  // to handle the error...we use try catch.
       Fraction f1=new Fraction(20, 30);
       f1.print();
       //2/3

       f1.setNumerator(12);
    // 4/1
        int d=f1.getDenominator();
        System.out.println(d);
        f1.print();

        f1.setNumerator(10);
        int i=10;
        try {           //to try handling exception
         i++;   // this will execute
        f1.setDenominator(0);
         i++;     //code after error dont execute
        }
        catch (zeroDenominatorException e){   //it catches error if try throws any...this catches a particular error
           System.out.println("Hey dont input zero as denominator");
        }
        catch(Exception e){ //this will catch all the errors that are not catched above of any name. as all the Exceptions extends Exception we can use this.
           System.out.println("generic exception");
        }
        finally{   // this will execute every time try function is used...no matter there is error or not....it is generally used to write common code from try and catch 

        }
        System.out.println(i);
        //1/3
        f1.print();

        Fraction f2=new Fraction(3, 4);
        f1.add(f2);
        f1.print();
        //f1=>13/12
        f2.print();
        //f2=>3/4

        Fraction f3=new Fraction(4, 5);
        f3.multiply(f2);
        f3.print();
        //f3=>3/5
        f2.print();
        //f2=>3/4

        Fraction f4=Fraction.add(f1, f3);
        f1.print();
        f3.print();
        f4.print();
   }
   public static void main(String[] args) throws zeroDenominatorException{
      temp();
   }
   

}
