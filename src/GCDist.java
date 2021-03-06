import java.text.DecimalFormat;

/* 
 * Calendar Object
 * 
 * Team Quartro
 */

/* Class */
public class GCDist
{
	/* Distance in Statute miles */
	public static double Statute_Miles(double lng1, double lat1, double lng2, double lat2)
	{
		/* Calculate distance */
		double result = Distance(lng1, lat1, lng2, lat2);
		System.out.println("result is " + result);
		/* Convert to statute miles */
		result = result * 69.047;
		return result;
	}

	/* Distance in Kilometers */
	public static double Kilometers(double lng1, double lat1, double lng2, double lat2)
	{
		/* Calculate distance */
		double result = Distance(lng1, lat1, lng2, lat2);
		
		/* Convert to statute miles */
		result = result * 111.12;
		return result;
	}
	
	/* Calculates the distance between two locations */
	private static double Distance(double lng1, double lat1, double lng2, double lat2)
	{
		/* Convert inputed angles to radians */
		double lng1_R = lng1*Math.PI/180;
		double lat1_R = Math.toRadians(lat1);
		double lng2_R = lng2*Math.PI/180;
		double lat2_R = Math.toRadians(lat2);
		
		/* For accuracy, we use the Vincenty formula */
		double vince_d = Vincenty(lng1_R, lat1_R, lng2_R, lat2_R);
    System.out.println("vinced is " + vince_d);

		
		/* Convert back to degrees */
		vince_d = Math.toDegrees(vince_d);
		
		return vince_d;
	}
	
	/* Vincenty formula, returns value in radians */
	private static double Vincenty(double lng1, double lat1, double lng2, double lat2)
	{
	   System.out.println("lngs are " + " " + lng1 + " " + lng2 + " " + lat1 + " " + lat2);

		/* Absolute value of the difference in longitude */
		double delta_lng = Math.abs(lng1 - lng2);
		
		/* Numerator pieces */
		double num1 = Math.pow((Math.cos(lat2) * Math.sin(delta_lng)),2);
		double num2 = Math.pow(((Math.cos(lat1) * Math.sin(lat2)) - (Math.sin(lat1) * Math.cos(lat2) * Math.cos(delta_lng))),2);
		double num = Math.sqrt(num1 + num2);
		
		/* Denominator */
		double den = (Math.sin(lat1) * Math.sin(lat2)) + (Math.cos(lat1) * Math.cos(lat2) * Math.cos(delta_lng)); 
		
		/* Result */
		double result = Math.atan2(num,den);
		return result;
	}
	//21.300620 -157.8162
	//21.304941 -157.817722
}