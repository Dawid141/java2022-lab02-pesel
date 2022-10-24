package pl.edu.uj.pesel;

import java.util.Objects;

public class Pesel {

  private static final Integer PESEL_LEN = 11;

  private final String pesel;

  public Pesel(String pesel) {
    this.pesel = pesel;
  }

  public static boolean compare(Pesel a, Pesel b) {
    return a.equals(b);
  }

  public static boolean check(Pesel pesel) {
    if (pesel.pesel.length() != PESEL_LEN) {
      return false;
    }

    int controlSum = 0; // TODO calculate controlSum

    int[] tab = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1};
    for (int i = 0; i < pesel.pesel.length(); i++){
      controlSum  += ((int) pesel.pesel.charAt(i) - 48) * tab[i];
    }

    return controlSum % 10 == 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pesel pesel1 = (Pesel) o;
    return Objects.equals(pesel, pesel1.pesel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pesel);
  }
}
