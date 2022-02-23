import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) throws Exception {
        Site nbp = new Site("https://api.nbp.pl/api/exchangerates/tables/A/?format=json");
        String nbpContent = nbp.getContent();
        CurrenciesTable[] table = new Gson().fromJson(nbpContent, CurrenciesTable[].class);

    }
}

