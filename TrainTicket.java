import java.io.*;
import java.util.*;

class Station {
	 private int noofstation;
	private  ArrayList<String> a;
	Station(int noofstation)
	{
		this.noofstation=noofstation;
		this.a= new ArrayList<String>(noofstation);
	}

	void AddStation(String s)
	{
		a.add(s);
	}
	int getnoofstation()
	{
		return noofstation;
	}
	int getindexOf(String s)
	{
		return a.indexOf(s);
	}
}

class  FirstTOLastStation
{
	private int cost=0;
	private int costof5station=20;
	private boolean flag;
	
	FirstTOLastStation(Station s, String source,String destination)
	{
		int s1=s.getindexOf(source);
		int d1=s.getindexOf(destination);
		if(d1-s1==s.getnoofstation()-1){
			cost=costof5station;
			flag= true;
		}
		else
			cost=0;
	}
	int value()
	{
		return cost;
	}


}


class UptoFiveStation{
	private int cost=0;
private boolean flag;
	UptoFiveStation(Station s, String source,String destination)
	{
		int s1=s.getindexOf(source);
		int d1=s.getindexOf(destination);
		if(d1-s1<5){
			cost=10;
			flag=true;
		}
		
	}
	int value()
	{
		return cost;
	}

}


class EachStation{
	private int cost=0;
	private boolean flag;
	private int EachStationcost=5;
	EachStation(Station s, String source,String destination)
	{
		int s1=s.getindexOf(source);
		int d1=s.getindexOf(destination);
		if(d1-s1>4 && d1-s1!=s.getnoofstation()-1){
			cost=(d1-s1-4)*EachStationcost;
			cost+=10;
			flag=true;
		}
		
	}
	int value()
	{
		return cost;
	}

}

class TotalCost{
	private int cost;
	TotalCost(Station s, String source,String destination)
	{
		 FirstTOLastStation f=new FirstTOLastStation( s,source,destination);
		 UptoFiveStation u=new UptoFiveStation(s,source,destination);
		 EachStation e=new EachStation(s,source,destination);
		this.cost=f.value()+u.value()+e.value();

	}
	int DisplayCost()
	{
		return cost;
	}
}

class BookTicket{
	private String source;
	private String destination;
	private Station s;
	BookTicket(Station s, String source,String destination)
	{
		this.source=source;
		this.destination=destination;
		this.s=s;

	}
	void Book()
	{
		 TotalCost t=new TotalCost(s,source, destination);
		System.out.println("Tolal cost :"+t.DisplayCost());

	}

}

class Train{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of station");
		int n=sc.nextInt();
		System.out.println("Enter the name of Station");
		Station s=new Station(n);

		for(int i=0;i<n;i++)
		{
			String p=sc.next();
			s.AddStation(p);
		}

		

		System.out.println("Enter source");
		String source=sc.next();
		System.out.println("Enter destination");
		String destination=sc.next();
		BookTicket b=new BookTicket(s,source,destination);
		b.Book();

	}
}