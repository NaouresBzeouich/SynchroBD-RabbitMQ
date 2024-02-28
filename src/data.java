import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class data {
    public String  date;
    public String Region;
    public String Product;
    public int Qty;
    public Double Cost;
    public Double Amount;
    public Double Tax;
    public Double Total;
    public data( String Ddte,String  Region, String  Product, int Qty, Double Cost, Double Amount, Double Tax, Double Total){
        this.date = date;
        this.Region = Region;
        this.Product = Product;
        this.Qty = Qty ;
        this.Cost = Cost;
        this.Amount = Amount;
        this.Tax = Tax;
        this.Total = Total ;
    }
    public String toString(){
        String s = "Date : "+ date + " , Region : "+Region+" , Product : "+Product+" , Qty : "+Qty  +", Cost : "+Cost+", Amount : "+Amount+" , Tax : "+Tax+" , Total : "+Total ;
        return s;
    }

    /**
     *
     * @param dataString witch must be in the form  "Date : "+ date + " , Region : "+Region+" , Product : "+Product+" , Qty : "+Qty  +", Cost : "+Cost+", Amount : "+Amount+" , Tax : "+Tax+" , Total : "+Total
     * @return
     */
    public static data toData(String dataString){
        String[] parts = dataString.split("\\s*,\\s*");

        String date = parts[0].split(":\\s+")[1];
        String region = parts[1].split(":\\s+")[1];
        String product = parts[2].split(":\\s+")[1];
        int qty = Integer.parseInt(parts[3].split(":\\s+")[1]);
        Double cost = Double.parseDouble(parts[4].split(":\\s+")[1]);
        Double amount = Double.parseDouble(parts[5].split(":\\s+")[1]);
        Double tax = Double.parseDouble(parts[6].split(":\\s+")[1]);


        data d = new data(date,region,product,qty,cost,amount,tax,tax);
        return d;
    }

    public static Object[][] dataToTable(Vector<data> d){
        Object[][] D = new Object[8][d.size()] ;
        return D;

    }

}
