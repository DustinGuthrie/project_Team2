/**
 * Created by Agronis on 11/5/15.
 */
public class StateCrime {
    String state;
    String abbrev;
    int year;
    int population;
    int crimeTotal;
    int murder;
    int manslaughter;
    int rape;
    int robbery;
    int assault;

    public StateCrime(){

    }

    public StateCrime(String state, String abbrev, int year, int population, int crimeTotal, int murder, int manslaughter, int rape, int robbery, int assault) {

        this.state = state;
        this.abbrev = abbrev;
        this.year = year;
        this.population = population;
        this.crimeTotal = crimeTotal;
        this.murder = murder;
        this.manslaughter = manslaughter;
        this.rape = rape;
        this.robbery = robbery;
        this.assault = assault;
    }
}
