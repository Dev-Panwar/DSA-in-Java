public class MinStepsToOne {
    public static int countMinStepsToOne(int n) {
		if(n==1){
            return 0;
        }
        int op1=countMinStepsToOne(n-1);
        int minSteps=op1;
        if(n%3==0){
            int op2=countMinStepsToOne(n/3);
             if(op2<minSteps){
                minSteps=op2;
             }
        }
        if(n%2==0){
            int op3=countMinStepsToOne(n/2);
             if(op3<minSteps){
                minSteps=op3;
             }
        }
        return 1+minSteps;    //koi na koi toh step hoga in 3 me se. isliye +1 
        
	}

    public static int countMinStepsToOneM(int n) {             //n+1 because we want to store number of steps for n in its nth index....eg for 10 we want 10th index.
        int storage[]=new int[n+1];
        for (int i = 0; i < storage.length; i++) {
            storage[i]=-1;
        }
        return countMinStepsToOneM(n,storage);
    }

    public static int countMinStepsToOneM(int n, int[] storage) {
        if(n==1){
            storage[n]=0;
            return storage[n];
        }
        if(storage[n]!=-1){
            return storage[n];
        }
        int op1=countMinStepsToOneM(n-1,storage);
        int minSteps=op1;
        if(n%3==0){
            int op2=countMinStepsToOneM(n/3,storage);
             if(op2<minSteps){
                minSteps=op2;
             }
        }
        if(n%2==0){
            int op3=countMinStepsToOneM(n/2,storage);
             if(op3<minSteps){
                minSteps=op3;
             }
        }
        return 1+minSteps;    //koi na koi toh step hoga in 3 me se. isliye +1 
    }

    public static int countMinStepsToOneDP(int n){
        int storage[]=new int[n+1];
        storage[1]=0;              //we are taking index same as n, so for n==1 means index 1 steps are 0
        for (int i = 2; i <=n ; i++) {
            int minSteps=storage[i-1];     //op1
            if(i%3==0){
                if(minSteps>storage[i/3]){  // option 2
                    minSteps=storage[i/3];
                }
            }
            if(i%2==0){
                if(minSteps>storage[i/2]){  // option 3
                    minSteps=storage[i/2];
                }
            }
            storage[i]=1+minSteps;
        }
        return storage[n];
    }

    public static void main(String[] args) {
        int n=100;
        System.out.println(countMinStepsToOneDP(n));
        System.out.println(countMinStepsToOneM(n));
        System.out.println(countMinStepsToOne(n));
        
    }
}
