package pl.edu.uj.pesel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class PeselValidator {

  private static final Logger logger = LoggerFactory.getLogger(PeselValidator.class);

  public static void main(String[] args) throws FileNotFoundException {
    // TODO should read input file path and write to output file
    File file = new File("input.txt");
    Scanner read = new Scanner(file);

    ArrayList<String> tab = new ArrayList<>();
    String pesele_war;
    while(read.hasNextLine()){
      pesele_war = read.nextLine();
      tab.add(pesele_war);
    }
    read.close();

    for (String arg : tab) {
      Pesel pesel = new Pesel(arg);
      boolean valid = Pesel.check(pesel);
      logger.info(MessageFormat.format("PESEL \"{0}\" is {1}", arg, valid ? "valid" : "invalid"));
    }


  }
}
