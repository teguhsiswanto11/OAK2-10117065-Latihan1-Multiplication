import javax.xml.bind.SchemaOutputResolver;

public class Operation {
    private int basic; // menyimpan basis/digit terbesar yang dipakai

//    fungsi menset basis terbesar dari dua variabel
    public int basis(int m, int q) {
        int con1 = 1;
        if (m <= 3) {con1=2;}
        else if (m <= 7) {con1=3;}
        else if (m <= 15) {con1=4;}
        else if (m <= 31) {con1=5;}
        else if (m <= 63) {con1=6;}
        else if (m <= 127) {con1=7;}
        else if (m <= 155) {con1=8;}
        else {con1=0;}

        int con2 = 1;
        if (q <= 3) {con2=2;}
        else if (q <= 7) {con2=3;}
        else if (q <= 15) {con2=4;}
        else if (q <= 31) {con2=5;}
        else if (q <= 63) {con2=6;}
        else if (q <= 127) {con2=7;}
        else if (q <= 155) {con2=8;}
        else {con2=0;}

        return this.basic = Math.max(con1,con2);}

//    mengecek apakah multiplier pada digit ke-0 sama dengan 1 (Q0 == 1)
    public int checkMultiplier0(String x){
        int totalDigit = x.length();
        char q0 = x.charAt(totalDigit-1);
        int y = Character.getNumericValue(q0);
        return y;}

//        konversi desimal ke biner (untuk basis bukan gabungan)
    public String decToBit(int y) {
        String x = "";
        String nol = "";

        while(y > 0) {
            int a = y % 2;
            x = a + x;
            y = y / 2;
        }
        if (basic > x.length()) {
            for (int i = 0; i < (basic - x.length()); i++) {
                nol += "0";
            }
        }
        return nol+x;}

//        konversi biner ke desimal (untuk basis bukan gabungan)
    public int bitToDec(String x) {
        double hasil = 0;
        int pow = x.length()-1;
        for (int i = 0; i < x.length(); i++) {
            int y = Character.getNumericValue(x.charAt(i));
            hasil = hasil + (y*(Math.pow(2,pow)));
            pow--;
        }
        int hasilInt = (int) hasil;
        return hasilInt;}

//      menggabungkan dua variabel dalam satu String (dalam bentuk biner)
    public String mergeCAQ(int a, int q) {
        String shift = decToBit(a)+decToBit(q);
        return shift;}

//      menguraikan bilangan desimal ke biner (untuk basis gabungan)
    public String parseToBit(int y, int basis) {
        String x = "";
        String nol = "";

        while(y > 0) {
            int a = y % 2;
            x = a + x;
            y = y / 2;
        }
        if (basis > x.length()) {
            for (int i = 0; i < (basis - x.length()); i++) {
                nol += "0";
            }
        }
        return nol+x;}

//        proses perkalian menggunakan algoritma penjumlahan biner (untuk bilangan positif)
    public int multiplication(int m, int q) {
        basis(m, q);
        int count = basic;
        int koun = basic-1; // untuk skema count
        int a = 0;

        System.out.println("\n\nC     A       Q       M      info   Count:"+count);
        System.out.println("--------------------------------------------");
        while (count != 0) {
            if (checkMultiplier0(decToBit(q)) == 1) {
                a +=  m;

            //untuk skema
                String dtb = decToBit(a);
                if (dtb.length() > 4) {
                    System.out.println(dtb.substring(0,1)+"   "+dtb.substring(1, 5)+"                      add");
                } else {
                    System.out.println("0"+"   "+dtb);
                }
            }
            String merge = mergeCAQ(a, q);
            int hasilMerge = bitToDec(merge);
//            System.out.println("sebelum : "+merge.substring(0, basic)+merge.substring(basic, basic*2));
            hasilMerge = hasilMerge >> 1;
            String parse = parseToBit(hasilMerge, basic*2);
            String parseA = parse.substring(0, basic);
            String parseQ = parse.substring(basic, basic*2);

            //untuk skema
//            koun -= 1;
            System.out.println("0   "+parseA+"    "+parseQ+"    "+decToBit(m)+"    shift    "+koun--);
            System.out.println(count == 1 ?"--------------------------------------------":"    ----+");

            a = bitToDec(parseA);
            q = bitToDec(parseQ);

            // untuk skema
            System.out.print(count == 1 ?"Biner A.Q = "+mergeCAQ(a,q)+"\n":"");

        count--;
        }

        String hasil = mergeCAQ(a, q);

    return bitToDec(hasil);}
}
