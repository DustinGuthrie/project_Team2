/**
 * Created by Agronis on 11/5/15.
 */
public class Crime {

    String state;
    int year;
    int population;
    int crimeTotal;
    int murder;
    int manslaughter;
    int rape;
    int robbery;
    int assault;

    public Crime(String state, int year, int population, int crimeTotal, int murder, int manslaughter, int rape, int robbery, int assault) {

        this.state = state;
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
