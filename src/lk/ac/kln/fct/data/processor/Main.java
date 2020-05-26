package lk.ac.kln.fct.data.processor;

import java.util.ArrayList;

import lk.ac.kln.fct.data.pojo.Record;

public class Main {
	private static final String FILE_PATH = "/Users/Darkness/eclipse-workspace/covid-19-data.json";
	private static final String DATE = "18/05/2020";
	
	public static void main(String[] args) {
		//TODO
		DataProcessor processor = new DataProcessor();
		
		ArrayList<Record> x = new ArrayList<Record>();		
		
		x = processor.getDataByDate(FILE_PATH, DATE);
		
		sortAndPrint(x);
		
	}
		
	public static void sortAndPrint(ArrayList<Record> records) {
		records.sort((record1, record2)-> Integer.compare(record2.getCases(), record1.getCases()));
		
		//TODO
		for(int i = 0 ; i < records.size();i++)
			
			if(records.get(i).getCases()>=1000) {
				System.out.println(records.get(i).getCountriesAndTerritories()+" : "+records.get(i).getCases()+" : "+records.get(i).getDeaths());
				
			}
	}
}
