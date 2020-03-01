package reports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

import domain.Model;

public class ProjektiReportService {

	private ProjektiReportService() {
		super();
	}

	private static ProjektiReportService instance;

	public static ProjektiReportService getInstance() {
		if (instance == null) {
			instance = new ProjektiReportService();
		}
		return instance;
	}

	public void makeReportOfModel(Model model) throws IOException {

		Path dataDir = Paths.get(System.getProperty("user.dir") + "/reporti/modeli");
		if (!Files.exists(dataDir)) {
			Files.createDirectories(dataDir);
		}

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String fileName = "model_" + model.getSifra() + "_" + dtf.format(LocalDate.now()) + ".txt";
		File f = new File(System.getProperty("user.dir") + "/reporti/projekti/" + fileName);

		StringBuilder sb = new StringBuilder();
		@SuppressWarnings("resource")
		Formatter formater = new Formatter(sb);

		formater.format("Projekat:%s\n", model.getNaziv());
		formater.format("Sifra projekta:%d\n", model.getSifra());
		formater.format("Datum pocetka projekta: %td.%<tm.%<ty\n", model.getDatumOd());
		formater.format("Datum zavrsetka projekta: %td.%<tm.%<ty\n", model.getDatumDo());

		formater.format("%-15s %-15s %5s   %10s %10s\n", "Ime", "Prezime", "h/dan", "datum pocetka", "datum zavrsetka");
		formater.format(
				"*********************************************************************************************************\n");
		/*
		 *   model.getListOfSome().stream().forEach(ang -> {
		 *   formater.format("%-15s %-15s %1.2f    %td.%<tm.%<tY     %td.%<tm.%<tY\n",
		 *   ang.getZaposleni().getIme(), ang.getZaposleni().getPrezime(),
		 *   ang.getBrojRadnhSatiDnevno(), ang.getDatumOd(), ang.getDatumDo()); });
		 */
		try (FileWriter fw = new FileWriter(f)) {
			fw.append(sb.toString());
			fw.flush();
		}

	}

}
