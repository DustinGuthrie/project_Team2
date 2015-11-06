/**
 * Created by MattBrown on 11/6/15.
 */
public class NationalCrime {
    int year;
    int population;
    int violentCrime;
    int murder;
    int rape;
    int robbery;
    int assault;

    public NationalCrime(){

    }

    public NationalCrime(int year, int population, int violentCrime, int murder, int rape, int robbery, int assault) {
        this.year = year;
        this.population = population;
        this.violentCrime = violentCrime;
        this.murder = murder;
        this.rape = rape;
        this.robbery = robbery;
        this.assault = assault;
    }
}
