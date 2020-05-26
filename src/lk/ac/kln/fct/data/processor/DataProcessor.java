package lk.ac.kln.fct.data.processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import lk.ac.kln.fct.data.pojo.Record;
import lk.ac.kln.fct.data.utils.Constants;

public class DataProcessor implements Constants{
	private static DateFormat dateformat = new SimpleDateFormat(DATE_FORMAT);
	/**
	 * This method reads the contents form a given JSON file and prints the required data.
	 * 
	 * @param filePath the path to JSON file.
	 */
	
	ArrayList<Record> x = new ArrayList<Record>();
	
	public ArrayList<Record> getDataByDate(String filePath, String searchDate) {
		try {
//			String fileContent = Files.readString(Paths.get(filePath));
			
			String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
			JSONObject obj  = new JSONObject(fileContent);
			JSONArray arr = obj.getJSONArray(JSON_ARRAY);
			
			
			
			for(int i = 0; i < arr.length(); i ++) {
				JSONObject element = arr.getJSONObject(i);
				if(element.getString(DATE).equals(searchDate)) {
					try {
						Date date = dateformat.parse(element.getString(DATE));
						int deaths = element.getInt(DEATHS);
						int cases = element.getInt(CASES);
						String country = element.getString(COUNTRY);
						String continent = element.getString(CONTINENT);
					
						//TODO Something is missing here
					Record rc = new Record(date, deaths, cases, country, continent);					
					
					x.add(rc);										
						
					} catch (JSONException | ParseException e) {
						e.printStackTrace();
					}					
				}				
			}
//			System.out.println(x.get(0).getCountriesAndTerritories());
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//TODO Something is wrong
		return x;
	}
}
