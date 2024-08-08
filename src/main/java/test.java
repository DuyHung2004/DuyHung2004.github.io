import dal.Productsdal;

public class test {
    public static void main(String[] args) {
        Productsdal productsdal= new Productsdal();
        System.out.println(productsdal.selectAll().get(0).getId());
    }
}
