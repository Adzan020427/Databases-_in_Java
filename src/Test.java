import javax.xml.crypto.Data;

public class Test {
    public static void main(String[] args) {
        Databases db = new Databases();
        db.open();
//        System.out.println(db.data);
        db.views();
    }
}
