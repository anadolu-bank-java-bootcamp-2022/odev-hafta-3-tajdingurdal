package com.gokhantamkoc.javabootcamp.odevhafta3.repository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;
import com.gokhantamkoc.javabootcamp.odevhafta3.util.TimeUtils;

public class CryptoDataCSVRepository implements CSVRepository {

	private final String COMMA_DELIMITER = ",";

	@Override // buranın içeriğini tamamla. .csv dosyasında ki bilgileri okumalısın.
	public List<Candle> readCSV(String filename) throws FileNotFoundException, IOException {
		List<Candle> candles = new ArrayList<Candle>();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
		// Bu alandan itibaren kodunuzu yazabilirsiniz
		
		try {

			Reader reader = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(reader); // InputStream convert to BufferedReader

			String line = "";
			int count = 0;

			String[] arr;
			while ((line = br.readLine()) != null) {
				arr = line.split(COMMA_DELIMITER);
				if (count == 0) {
					count++;
					continue;
				}
				long milisecond = TimeUtils.convertToMillisTime(arr[0]);
				long second = milisecond / 1000;
				long min = second / 60;
				long hour = min / 60;
				candles.add(new Candle(hour, Double.parseDouble(arr[3]), Double.parseDouble(arr[4]),
						Double.parseDouble(arr[5]), Double.parseDouble(arr[6]), Double.parseDouble(arr[7])));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Bu alandan sonra kalan kod'a dokunmayiniz.
		return candles;
	}

}
