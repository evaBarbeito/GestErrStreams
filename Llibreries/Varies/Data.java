package Varies;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class Data {
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

	
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
