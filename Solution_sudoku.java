public class Solution_sudoku {
	public int isValidSudoku(final List<String> a) 
	{
	    String[] ar = a.toArray(new String[0]);
	    int r[][]= new int[9][9];
        int c[][]= new int[9][9];
        int b[][]= new int[9][9];
        int j,i,kr,kc,k,p=0;
        char x;
        for (i=0;i<9;i++)
        {
            for(j=0;j<9;j++)
            {
                x=ar[i].charAt(j);
                //y=ar[j].charAt(i);
                if(x!='.'/* && y!='.'*/)
                {
                    kr=Character.getNumericValue(x);
                    //kc=Character.getNumericValue(y);

                    if((kr>=1 && kr<=9) /*&& (kc>=1 && kc<=9)*/)
                    {
                        if(r[i][kr-1]==0)
                            r[i][kr-1]=1;
                        else
                            return 0;
                        if(c[j][kr-1]==0)
                            c[j][kr-1]=1;
                        else 
                            return 0;
                    }
                    else
                        return 0;
                }
                else
                    continue;
            }
        }
        for(k=0;k<3;k++)
        {
            for(j=3*k;j<3*(k+1);j++)
            {
                for(i=0;i<9;i++)
                {
                    x=ar[i].charAt(j);
                    if(x!='.')
                    {
                        kr=Character.getNumericValue(x);
                        if((kr>=1 && kr<=9))
                        {
                            p=3*k+((int)(i/3));
                            if(b[p][kr-1]==0)
                                b[p][kr-1]=1;
                            else 
                                return 0;
                        }
                        else
                            return 0;
                     }
                 }
             }
        }
        return 1;
	}
}
