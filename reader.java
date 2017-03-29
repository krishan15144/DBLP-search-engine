import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import java.util.ArrayList;
public class reader extends DefaultHandler
{
    boolean checkauthor= false;
    boolean checkpages= false;
    boolean checktitle= false;
    boolean checkUrl= false;
    boolean checkNumber= false;
    boolean checkEe= false;
    boolean checkYear=false;
    boolean checkJournal=false;
    boolean checkVolume=false;
    book bookname;
    public ArrayList<book> bookinformation=new ArrayList<book>();

    public void startElement(String url,String localName,String qName,Attributes attributes)throws SAXException
    {
        if (qName.equalsIgnoreCase("article"))
        {
            bookname= new book();
        }
        else if(qName.equalsIgnoreCase("pages"))
        {
            checkpages=true;
        }
        else if(qName.equalsIgnoreCase("author"))
        {
            checkauthor=true;

        }
        else if(qName.equalsIgnoreCase("journal"))
        {
            checkJournal=true;
        }
        else if(qName.equalsIgnoreCase("ee"))
        {
            checkEe=true;
        }
        else if(qName.equalsIgnoreCase("title"))
        {
            checktitle=true;
        }
        else if(qName.equalsIgnoreCase("volume"))
        {
            checkVolume=true;
        }
        else if(qName.equalsIgnoreCase("year"))
        {
            checkYear=true;
        }
        else if(qName.equalsIgnoreCase("number"))
        {
            checkNumber=true;

        }
        else if(qName.equalsIgnoreCase(url))
        {
            checkUrl=true;

        }
    }
    public void endElement(String url,String localName,String qname )throws SAXException
    {
        if(qname.equalsIgnoreCase("article"))
        {
            //     ("uioii");
            bookinformation.add(bookname);
        }
        else if(qname.equalsIgnoreCase("dblp"))
        {
            printAll();
        }
    }
    public void characters(char ch[],int start,int length)throws SAXException
    {
        if(checkauthor==true)
        {
            bookname.setAuthor(new String(ch,start,length));
            checkauthor=false;
        }
        else if(checkpages==true)
        {
            bookname.setNoofPages(new String(ch,start,length));
            checkpages=false;
        }
        else if(checkYear==true)
        {
            bookname.setYear(new String(ch,start,length));
            checkYear=false;
        }
        else if(checkNumber==true)
        {
            bookname.setNumber(new String(ch,start,length));
            checkNumber=false;
        }
        
        else if(checktitle==true)
        {
            bookname.setTitle(new String(ch,start,length));
            checktitle=false;
        }
        else if(checkVolume==true)
        {
            bookname.setVolume(new String(ch,start,length));
            checkVolume=false;
        }
        else if(checkJournal==true)
        {
            bookname.setJournal(new String(ch,start,length));
            checkJournal=false;
        }
        
    }
    public void printAll()
    {
        for(book b : bookinformation)
        {
            System.out.println(b);
        }

    }
    public void print()
    {
        System.out.println(bookinformation.size());
    }
    public ArrayList<book> getall()
    {
        return(bookinformation);
    }



}