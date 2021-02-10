package day11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeliveryProject {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		DeliverProduct factory=(DeliverProduct)Class.forName("day11.FlipkartDelivery").newInstance();
		int s=factory.CourierBoyTravelTime(600);
		System.out.println("Total Hours To Deliver:"+s+"hrs");
		int ExceptedtimeTaken=factory.totalHoursTaken(s);
		factory.ExpectedDeliveryDate(ExceptedtimeTaken);
	}
}

interface Delivery{
	int Travelhrs=8;
	int speed=70;
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	public int CourierBoyTravelTime(int distance);
	public int totalHoursTaken(int hours);
	public void ExpectedDeliveryDate(int ExceptedtimeTaken);

}
abstract class DeliverProduct implements Delivery{
	
	}
class FlipkartDelivery extends DeliverProduct{
	LocalDateTime CTime;
	@Override
	public int CourierBoyTravelTime(int distance) {
		// TODO Auto-generated method stub
		
		return distance/speed;
	}
	FlipkartDelivery(){
		LocalDateTime currentDateTime = LocalDateTime.of(2017, 2, 14, 14, 0);
		//LocalDateTime currentDateTime=LocalDateTime.now();
		String formatDateTime =currentDateTime .format(format);  
		System.out.println("Current Date: " + formatDateTime);  

	    CTime=currentDateTime;
	}
	@Override
	public int totalHoursTaken(int hours) {
		int remainingTime=0;
		// TODO Auto-generated method stub
		if(CTime.getHour()>8 && CTime.getHour()<16) {
			remainingTime=16-CTime.getHour();
			
		}
		if(CTime.getHour()<8) {
			int value=8-CTime.getHour();
			CTime=CTime.plusHours(value);

		}
		CTime=CTime.plusHours(remainingTime);

		return hours-remainingTime;
	}
	@Override
	public void ExpectedDeliveryDate(int ExceptedtimeTaken) {
		// TODO Auto-generated method stub
		int flag=0;
		int nextday=0;
		int nextdaytime1=0;
		LocalDateTime ExpectedDeliveryTime;
		int totalhours=ExceptedtimeTaken%Travelhrs;
		int totaldays=ExceptedtimeTaken/Travelhrs;
		System.out.println("Hours and days"+totalhours+":"+totaldays);
		LocalDateTime ExpectedDeliveryDate=CTime.plusDays((totaldays));
		if(totaldays==0) {
			System.out.println("Sd");
			flag=1;
			ExpectedDeliveryDate=CTime.plusHours((totalhours));
			if(ExpectedDeliveryDate.getHour()>16) {
				nextday=24-ExpectedDeliveryDate.getHour();
				nextdaytime1=ExpectedDeliveryDate.getHour()-16;
				
				ExpectedDeliveryDate=ExpectedDeliveryDate.plusHours(nextday+8);
				ExpectedDeliveryDate=ExpectedDeliveryDate.plusHours(nextdaytime1);
				
			}
		}
		if(ExpectedDeliveryDate.getHour()>16) {
			System.out.println("2");
			nextday=24-ExpectedDeliveryDate.getHour();
			ExpectedDeliveryDate=ExpectedDeliveryDate.plusHours(nextday+8);
			
		}
		if(flag==1) {
			System.out.println("5");
			ExpectedDeliveryTime=ExpectedDeliveryDate;
		}else
		{	System.out.println("56");
			ExpectedDeliveryTime=ExpectedDeliveryDate.plusHours(totalhours); 
		}
		if(ExpectedDeliveryTime.getHour()>16) {
			System.out.println("3");
			nextday=24-ExpectedDeliveryTime.getHour();
			ExpectedDeliveryTime=ExpectedDeliveryTime.plusHours(nextday+8);
			ExpectedDeliveryTime=ExpectedDeliveryTime.plusHours(totalhours);
		}
		System.out.println(ExpectedDeliveryTime);
		String formatDateTime =ExpectedDeliveryTime .format(format);  
	    System.out.println("Expected Date: " + formatDateTime);  
		
	}
	
}