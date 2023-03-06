package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {
//ICE3
	//getMilliseconds test 
	@Test
	public void testGetMilliseconds()
	{
	int Milliseconds =Time.getMilliseconds("12:05:05:005");
	assertTrue("The milliseconds were not calculated properly", Milliseconds==5);
	}

	//get total milliseconds 
	@Test
	public void testGetTotalMilliseconds()
	{
	int TotalMilliseconds =Time.getTotalMilliseconds("05:05:05:005");
	assertTrue("The milliseconds were not calculated properly", TotalMilliseconds == 18305005);
	}
	
//ICE2
	//test Get total seconds Good, Bad, and Boundary 
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15","05:59:59" })
	void testGetTotalSecondsGoodAndBoundary(String candidate) {
	int seconds = Time.getTotalSeconds(candidate);
	assertTrue("The Total seconds were not calculated properly", seconds == 18000 ||seconds ==18915 || seconds == 21599);
	}
	
	@Test
	public void testGetTotalSecondsBad(){
	assertThrows(
	StringIndexOutOfBoundsException.class,
	()-> {Time.getTotalSeconds("00:00");});
	}

	//test Get Seconds Good, Bad, and Boundary 
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15","05:59:59" })
	void testGetSecondsGoodAndBoundary(String candidate) {
	int seconds = Time.getSeconds(candidate);
	assertTrue("The Seonds were not calculated properly", seconds ==00 || seconds == 15 || seconds ==59);
	}

	@Test
	public void testGetSecondsBad(){
	assertThrows(
	StringIndexOutOfBoundsException.class,
	()-> {Time.getSeconds("00:00");});
	}
	
	//test Get total Minutes Good, Bad, and Boundary 
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15","05:59:59" })
	void testGetTotalMinutesGoodAndBoundary(String candidate) {
	int minutes = Time.getTotalMinutes(candidate);
	assertTrue("The Minutes were not calculated properly", minutes ==00 || minutes == 15 || minutes ==59);
	}

	@Test
	public void testGetTotalMinutesBad(){
	assertThrows(
	StringIndexOutOfBoundsException.class,
	()-> {Time.getTotalMinutes("00");});
	}
	
	//test GEt total Hours Good, Bad, and Boundary 
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15","05:59:59" })
	void testGetTotalHoursGoodAndBoundary(String candidate) {
	int hours = Time.getTotalHours(candidate);
	assertTrue("The hours were not calculated properly", hours ==5);
	}

	@Test
	public void testGetTotalHoursBad(){
	assertThrows(
	StringIndexOutOfBoundsException.class,
	()-> {Time.getTotalHours("");});
	}
	


}
