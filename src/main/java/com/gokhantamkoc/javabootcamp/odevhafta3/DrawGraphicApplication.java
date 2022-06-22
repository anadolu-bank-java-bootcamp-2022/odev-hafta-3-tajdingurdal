package com.gokhantamkoc.javabootcamp.odevhafta3;

import java.io.File;

import org.jfree.chart.ChartUtilities;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gokhantamkoc.javabootcamp.odevhafta3.repository.CryptoDataCSVRepository;
import com.gokhantamkoc.javabootcamp.odevhafta3.service.ChartService;

@SpringBootApplication
public class DrawGraphicApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(DrawGraphicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ChartService chartService = new ChartService(
			new CryptoDataCSVRepository()
		);
		ChartUtilities.saveChartAsPNG(
				new File("result.png"), 
				chartService.createChartFromCryptoData().getCandleStickChart(), 
				1000, 1000);
	}
}

/*
 * Görev özeti: resources klasoründe ki .csv uzantılı dosya içerisinde ki
 * verileri bir mum grafiğine dönüştür.
 * 
 * DrawGraphicApplication çalıştırdığınızda, proje klasöründe result.png adında
 * bir dosya oluşacaktır. Burada oluşan grafiği görebileceksiniz.
 */

/*
 * PROJE PLANI: 
 * 1. Önce readCSV(String filename) metodu ile .csv dosyasında ki bilgileri okumalısın. Ve List<Candle> döndürmelisin.
 * 2. .csv dosyasında ki bilgileri okuduktan sonra createChartFromCryptoData() ile .csv dosyasınan okuduğun bilgiler ile bir grafik oluştur.
 * 
 */