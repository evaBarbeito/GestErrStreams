package Varies;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.TimeZone;

public abstract class Data {
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

	
	/**
     * @param args the command line arguments
     */
    public static String imprimirLongTime(long time){
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        cal.setTimeInMillis(time);
        return (cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" 
                + cal.get(Calendar.YEAR) + " a les " + cal.get(Calendar.HOUR_OF_DAY) + "h "
                + cal.get(Calendar.MINUTE) + "' " + cal.get(Calendar.SECOND) + "'' " + cal.get(Calendar.MILLISECOND));

    }

	public static String imprimirData(LocalDateTime dataTmp) {
		if (dataTmp == null) {
        	return "NULL";
        } else {
        	return dataTmp.format(formatter);
        }
	}
	
	// PER L'EXAMEN:
	public static boolean esData(String dataTmp) {
		boolean esCorrecta = true;
		int numParamLLegits;
/*
  	Per a quan hagin vist excepcions:		
		LocalDate parsedDate = LocalDate.parse(dataTmp, formatter);
		
		Parameters:
		    text - the text to parse, not null
		Returns:
		    the parsed temporal object, not null
		Throws:
		    DateTimeParseException - if unable to parse the requested result

		LocalDateTime parsedDate;
		try {
			parsedDate = LocalDateTime.parse(dataTmp, formatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
*/
		//tres números separats per guió
		numParamLLegits = dataTmp.split("-").length;
		if (numParamLLegits != 3) {
			esCorrecta = false;	
		} else {
			for (String data: dataTmp.split("-")) {
				if (!Cadena.stringIsInt(data)) {
					esCorrecta = false;
				}
		    }
		}
	
		return esCorrecta;
	}
}
