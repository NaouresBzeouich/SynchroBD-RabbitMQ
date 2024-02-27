public class HO {
    public static void main(String[] args) {
        try {
            Receive receiver = new Receive("BO1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Receive receiver = new Receive("BO2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
