public class Solution_power {
	public int pow(int x, int n, int d)
	{
	    int ar[]=new int[100];
    	long rem[]= new long[100];
    	int p=n,k=0,i,res;
    	if (x==0)
    	    return 0;
    	while(p>0)
    	{
    		ar[k++]=p%2;
    		p=p/2;
    	}
         
         p=0;
   		 long pro=1;
         rem[0]=x%d;
         if(ar[0]==1)
         	pro=rem[0];
         for(i=1;i<k;i++)
         {
         	rem[i]=(rem[i-1]*rem[i-1])%d;
         	if(ar[i]==1)
         	{
         		pro*=rem[i];
         		pro=pro%d;
         	}
         }
         res=(int)(pro);
         if(res<0)
         	res+=d;
         return res;

	}
}
