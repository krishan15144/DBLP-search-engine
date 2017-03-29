import java.util.*;

public class entity_reso_rel
{
    
    public void relevance(String str1,String str2,ArrayList<String> array1,ArrayList<String> array2,int len1,int len2,HashMap<String,Integer> full,HashMap<String,book> fullobj,book b)
    {
        if(str1.equals(str2))
        {

            full.put(str1, 3);
            fullobj.put(str2, b);
        }
        else if(array1.get(0).charAt(0)==array2.get(0).charAt(0))
        {

            if(array2.get(0).contains("."))
            {
                if(array1.get(len1-1).equals(array2.get(len2-1)))
                {
                    full.put(str2,2);
                    fullobj.put(str2, b);
                }
                else if(array1.get(len1-1).equals(array2.get(len2-1))&& (array2.get(0).contains(".") || array1.get(0).contains(".")))
                {
                	full.put(str2,2);
                	fullobj.put(str2, b);
                }
                else
                    full.put(str2,0);
                	fullobj.put(str2, b);
            }
            if(array2.get(len2-1).contains("."))
            {
                if(array1.get(0).equals(array2.get(0)))
                {
                    full.put(str2,2);
                    fullobj.put(str2, b);
                }
                else
                {
                    full.put(str2,0);
                	fullobj.put(str2, b);
                }
            }
            if(array2.get(0).equals(array1.get(0)))
            {
                full.put(str2,1);
                fullobj.put(str2, b);
            }

        }
        else if(array1.get(len1-1).equals(array2.get(len2-1))||array1.get(0).equals(array2.get(0)) )
        {
            full.put(str2,1);
            fullobj.put(str2, b);
        }

        //return 0;
    }

    public void inp(String str1,String str2,HashMap<String,Integer> full,HashMap<String,book> fullobj,book b)
    {
        ArrayList<String> array1=new ArrayList<String>(Arrays.asList(str1.split(" ")));
        ArrayList<String> array2=new ArrayList<String>(Arrays.asList(str2.split(" ")));
        int len1=array1.size();
        int len2=array2.size();
        relevance(str1,str2,array1,array2,len1,len2,full,fullobj,b);

    }
    public void m(String str1,String str2,HashMap<String,Integer> full,HashMap<String,book> fullobj,book b)
    {
        entity_reso_rel k=new entity_reso_rel();
        k.inp(str2,str1,full,fullobj,b);
//        for(Map.Entry<String,Integer> ee:k.full.entrySet())
//        {
        
//            //if(ee.getValue()==l)
//            {
//                System.out.println(ee.getKey());
//            }
//            System.out.println("juii");
//
//        }
//        int l=3;
//        while(l!=-1)
//        {
//            for(Map.Entry<String,Integer> e:full.entrySet())
//            {
//                if(e.getValue()==l)
//                {
//                    System.out.println(e.getKey()+" "+l);
//                }
//
//            }
//            l--;
//        }
    }

}
