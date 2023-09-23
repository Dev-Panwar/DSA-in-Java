package ComplexNumbers;

public class ComplexNumbers {
    private int Real;
    private int Imaginary;

    public ComplexNumbers(int Real, int Imaginary){
        this.Real=Real;
        this.Imaginary=Imaginary;
    }

    public int getReal(){
        return Real;
    }

    public int getImaginary(){
        return Imaginary;
    }

    public void setReal(int r){
        this.Real=r;
    }

    public void setImaginary(int i){
        this.Imaginary=i;
    }

    public void plus(ComplexNumbers c2){
        this.Real=this.Real+c2.Real;
        this.Imaginary=this.Imaginary+c2.Imaginary;

    }

    public void multiply(ComplexNumbers c2){
        int real1=this.Real;
        int imaginary1=this.Imaginary;
        this.Real=real1*c2.Real-imaginary1*c2.Imaginary;
        this.Imaginary=real1*c2.Imaginary+imaginary1*c2.Real;

    }

    public void print(){
        System.out.println(Real+"+"+Imaginary+"i");
    }
    public static ComplexNumbers plus(ComplexNumbers c1, ComplexNumbers c2){
        int real1=c1.Real+c2.Real;
        int imaginary1=c1.Imaginary+c2.Imaginary;
        ComplexNumbers c=new ComplexNumbers(real1, imaginary1);
        return c;
    }
}
