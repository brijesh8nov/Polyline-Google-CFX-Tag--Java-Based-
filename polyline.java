/* Polyline Algorithm implementation 
* created by BRIJESH CHAUHAN : brijesh@brijeshradhika.com
* version 1.0
* created Date : 04 Aug 2011
* Notes - This is still in DEVELOPMENT and broken as of NOW.
*/
import com.allaire.cfx.* ;
public class polyline implements CustomTag {
        public void processRequest( Request request, Response response ) 
    throws Exception { 
            int num = request.getIntAttribute("COORDINATE");
            num = (int)(Math.round(num * 1e5));
            int sgn_num = num << 1; 
            if (num < 0) { 
                sgn_num = ~(sgn_num); 
            } 
            StringBuffer encodeString = new StringBuffer();
            while (sgn_num >= 0x20) 
		   	{ 
            	encodeString.append((char)((0x20 | (sgn_num & 0x1f)) + 63)); 
            	sgn_num >>= 5; 
        	} 
       	encodeString.append((char)(sgn_num + 63));
    response.write(encodeString.toString()) ; 
    } 
}