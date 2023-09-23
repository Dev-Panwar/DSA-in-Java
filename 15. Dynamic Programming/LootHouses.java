public class LootHouses {
    public static int maxMoneyLooted(int[] houses) {
		//Your code goes here
        
         if (houses.length==0)
            return 0;
        
        if (houses.length==1)
            return houses[0];
        
        if (houses.length==2)      //agar 2 hi ghar hain toh dono me se jyada ameer ko lootega
            return Math.max(houses[0],houses[1]);
        
        int n = houses.length;
        int[] dp = new int[n];
        dp[0]=houses[0];
        dp[1]=Math.max(houses[0],houses[1]);
        
        for (int i=2;i<n;i++)
        {
            int maxVal1=dp[i-2]+houses[i];   //agar pehle ke pehle wale ko include kar raha hai
            
            
            int maxVal2=dp[i-1];             // upar wale dono ke beech wala
            
           
            dp[i]=Math.max(maxVal1,maxVal2);   //dono me se jo max hai usko lenge
        }
        
        
        return dp[n-1];
	}
}
