import java.util.Scanner;

public class UserInterFace {

    public static void tampilkanMenu(){
        System.out.println();
        System.out.println("+=================+");
        System.out.println("|   pilih menu:   |");
        System.out.println("+-----------------+");
        System.out.println("|  [C] : Create   |");
        System.out.println("|  [R] : Read     |");
        System.out.println("|  [U] : Update   |");
        System.out.println("|  [D] : Delate   |");
        System.out.println("|  [E] : Exit     |");
        System.out.println("+=================+");
    }
    public static void main(String[] args) {
        Databases db = new Databases();
        System.out.println("APLIKASI SEDERHANA CRUD TEXT DATABASE");
        while(true){
            tampilkanMenu();
            Scanner sc = new Scanner(System.in);
            System.out.println("PILIH : ");
            String pilihan = sc.nextLine();
            pilihan = pilihan.toUpperCase();

            switch (pilihan){
                case "C":
                    System.out.println("ANDA MEMILIH MENU CREATE");
                    System.out.println("-------------------------------------");
                    System.out.println("INPUT DATA BARU  ");
                    System.out.println("NIM            : ");
                    String nim = sc.nextLine();
                    System.out.println("NAMA MAHASISWA : ");
                    String nama = sc.nextLine();
                    System.out.println("ALAMAT         : ");
                    String alamat = sc.nextLine();
                    System.out.println("SEMESTER       : ");
                    int semester = sc.nextInt();
                    System.out.println("SKS            : ");
                    int sks = sc.nextInt();
                    System.out.println("IPK            : ");
                    double ipk = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("-----------------------------------------");
                    boolean status = db.insert(nim,nama,alamat,semester,sks,ipk);
                    if (status == true) {
                        System.out.println("DATA BARU BERHASIL DITAMBAHKAN");

                    }else {
                        System.out.println("NIM"+nim+" sudah ada di databse");
                        System.err.println("GAGAL MENAMBAHKAN DATA BARU");
                    }
                    System.out.println("-----------------------------------------");
                    break;
                case "R":
                    System.out.println("ANDA MEMILIH MENU READ");
                    db.views();
                    break;
                case "U":
                    System.out.println("ANDA MEMILIH MENU UPDATE");
                    db.views();
                    System.out.println("Input key (NIM Mahasiswa yang akan diupdate)");
                    String key = sc.nextLine();
                    int index = db.search(key);
                    if (index >= 0) {
                        System.out.println("Anda akan meng-update data: " + db.getData().get(index));
                        System.out.println("-------------------------------------");
                        System.out.println("INPUT DATA BARU  ");
                        System.out.println("NIM            : ");
                        nim = sc.nextLine();
                        System.out.println("NAMA MAHASISWA : ");
                        nama = sc.nextLine();
                        System.out.println("ALAMAT         : ");
                        alamat = sc.nextLine();
                        System.out.println("SEMESTER       : ");
                        semester = sc.nextInt();
                        System.out.println("SKS            : ");
                        sks = sc.nextInt();
                        System.out.println("IPK            : ");
                        ipk = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("-----------------------------------------");
                        status = db.update(index, nim,nama,alamat,semester,sks,ipk);
                        if (status==true){
                            System.out.println("DATA BERHASIL DITAMBAHKAN");
                        }else {
                            System.err.println("GAGAL MEMPERBAHARUI DATA");
                        }
                        System.out.println("-----------------------------------------");
                    }else {
                        System.err.println("Mahasiswa dengan NIM: "+ key + "tidak ada dalam database");
                    }
                    break;
                case "D":
                    System.out.println("ANDA MEMILIH MENU DELETE");
                    db.views();
                    System.out.println("Input key (NIM Mahasiswa yang akan dihapus) : ");
                    key = sc.nextLine();
                    index = db.search(key);
                    if (index >= 0) {
                        System.out.println("APAKAH ANDA YAKIN INGIN MENGHAPUS DATA INI "+db.getData().get(index));
                        System.out.println("Pilih (Y/N): ");
                        pilihan = sc.nextLine();
                        if (pilihan.equalsIgnoreCase("Y")) {
                            status = db.delete(index);
                            if (status == true) {
                                System.out.println("DATA BERHASIL DIHAPUS");
                            }else {
                                System.err.println("GAGAL MENGHAPUS DATA");
                            }
                        }
                    }else {
                        System.err.println("Mahasiswa dengan NIM: " + key + "tidak ada dalam database");
                    }
                    break;
                case "X":
                    System.out.println("Info: Anda memilih menu EXIT");
                    System.out.println("APAKAH ANDA YAKIN INGIN KELUAR DARI APLIKASI? Y/N");
                    System.out.println("pilih : ");
                    pilihan = sc.nextLine();
                    if (pilihan.equalsIgnoreCase("Y")) {
                        System.exit(0);
                    }
                    break;
            }
        }
    }
}
