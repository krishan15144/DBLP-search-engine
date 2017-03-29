import java.util.ArrayList;
import java.util.*;
public class entity_resolution
{
	
	/*public entity_resolution(String str1,String str2)
	{
		this.str1=str1;
		this.str2=str2;
		//System.out.println(str1);
	}*/


    int flag=0;
    public int er(String str1,String str2,ArrayList<String> array1,ArrayList<String> array2,int len1,int len2)
    {
        //System.out.println(array1.get(0));
        //System.out.println(len1+" "+len2);
        int minlen=(len1<len2)?len1:len2;
        int maxlen=(len1>len2)?len1:len2;
        if(str1.equals(str2))
        {
            return 1;
        }
        if(minlen==1)
        {
            if(array1.get(0).charAt(0)==array2.get(0).charAt(0))
            {
                
            	if(array2.get(0).contains(".") || array1.get(0).contains("."))
            		return 2;

            }
        }
        if(array1.get(0).charAt(0)==array2.get(0).charAt(0) && array1.get(len1-1).charAt(0)==array2.get(len2-1).charAt(0))
        {
            if(array1.get(0).charAt(0)==array2.get(0).charAt(0) && array2.get(len2-1).equals(array1.get(len1-1)))
            {
            	if(array2.get(0).contains(".") || array1.get(0).contains("."))
            		return 2;
            }
            if(array1.get(len1-1).charAt(0)==array2.get(len2-1).charAt(0) && array2.get(0).equals(array1.get(0)))
            {
            	if(array2.get(len2-1).contains(".") || array2.get(len2-1).contains("."))
            		return 2;
            }

        }
        return 0;
    }
    public boolean middle(String str1,String str2,ArrayList<String> array1,ArrayList<String> array2,int len1,int len2)
    {

        int maxlen;
        int minlen;
        len1=len1-2;
        len2=len2-2;
        if(len1>=len2)
        {
            maxlen=len1;
            minlen=len2;
        }
        else
        {
            maxlen=len2;
            minlen=len1;
        }
        if(len1==0 || len2==0)
        {
            return true;
        }
        else
        {
            int count=0;
            System.out.println("gohj");
            System.out.println(maxlen+"+"+minlen);
            for(int j=1 ; j<minlen+1 ; j++)
            {
                for(int i=1 ; i<maxlen+1 ; i++)
                {
                    System.out.println("ghpj");
                    if(array1.get(i).charAt(0)==array2.get(j).charAt(0))
                    {
                        System.out.println("ghj");
                        if(array1.get(i).equals(array2.get(j)))
                        {
                            count=count+1;
                            break;
                        }
                        if(array1.get(0).contains(".") || array2.get(0).contains("."))
                        {
                            count=count+1;
                            break;
                        }

                    }

                }

            }

            System.out.println(count+"+"+minlen);
            if(count==minlen)
            {
                return true;
            }
            else
                return false;
        }
    }

    public boolean enr(String str1,String str2)
    {
        //entity_resolution k = new entity_resolution();
        //System.out.println(k.str1);
    	try
    	{
    		ArrayList<String> array1 = new ArrayList<String>(Arrays.asList(str1.split(" ")));
    		ArrayList<String> array2 = new ArrayList<String>(Arrays.asList(str2.split(" ")));
    		int len1=array1.size();
    		int len2=array2.size();
    		boolean r;
    		int kit=er(str1,str2,array1,array2,len1,len2);
    		if(kit==1)
    			return true;
    		else if(kit==2)
    		{
    			r=middle(str1,str2,array1,array2,len1,len2);
    			return r;
    		}
    		else
    			return false;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    }
}