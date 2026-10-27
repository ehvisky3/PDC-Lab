public class FixOrderEvent extends TradeEvent
{
	private String id;
	public FixOrderEvent(String s,long t,double p,String i)
	{
		super(s,t,p);
		id=i;
	}
	@Override
	public void dispatch()
	{
		double fee=price*0.0067;
		double total=price+fee;
		System.out.println("Fix Order | Order ID= "+id+" | Sender: "+sender+" | Base Price= "+price+" | Fee = "+fee+" | Total= "+total);
	}
}