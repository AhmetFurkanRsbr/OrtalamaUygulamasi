public class OkulHarfNotlari {

    static int index=0;
    static float dersGecmeNotu=0.00f;
    float harfinDortlukDonusumu;
    float []notAraliklariArray= new float[10];
    boolean isDonguBitir=false;

    enum Okullar{
        TopkapiHarfNotu,
        TekirdagNamikKemalHarfNotu
    }
    Okullar kisininOkulu;

    enum kisiHarfNotu{
        AA,
        BA,
        BB,
        CB,
        CC,
        DC,
        DD,
        FD,
        FF
    }
    kisiHarfNotu not;
    enum TopkapiHarfNotu {
        AA,//100-90
        BA,//89-85
        BB,//84-80
        CB,//79-70
        CC,//69-60
        DC,//59-55
        DD,//54-50
        FD,//49-40
        FF//39-0
    }
    //TopkapiHarfNotu not;

    enum TekirdagNamikKemalHarfNotu{
        AA,//100-90
        BA,//89-80
        BB,//79-70
        CB,//69-65
        CC,//64-60
        DD,//59-50
        FD,//49-30
        FF//29-0
    }
    //TekirdagNamikKemalHarfNotu not2;


    public static void dersGecmeNotuGetir(float dersGecmeNotu){
       OkulHarfNotlari.dersGecmeNotu=dersGecmeNotu;
    }


    public  float dortlukSistemdeOrtalamaDonustur(float gecmeNotu,String kisininOkuluString) {
        System.out.println("okulunuz: " + kisininOkuluString);
        System.out.println("gecme Notu:" + gecmeNotu);
        switch (kisininOkuluString) {
            case "İstanbul Topkapı Üniversitesi":
                kisininOkulu = Okullar.TopkapiHarfNotu;
                notAraliklariArray[0] = 100.00f;//1.üst
                notAraliklariArray[1] = 89.0f;//2.üst
                notAraliklariArray[2] = 84.00f;//3.üst
                notAraliklariArray[3] = 79.00f;//4.üst
                notAraliklariArray[4] = 69.00f;//5.üst
                notAraliklariArray[5] = 59.00f;//6.üst
                notAraliklariArray[6] = 54.00f;//7.üst
                notAraliklariArray[7] = 49.00f;//8.üst
                notAraliklariArray[8] = 39.00f;//9.üst
                notAraliklariArray[9] = 0.00f;//son
                break;

            case "Tekirdağ Namık Kemal Üniversitesi":
                kisininOkulu = Okullar.TekirdagNamikKemalHarfNotu;

                notAraliklariArray[0] = 100.00f;//1.üst
                notAraliklariArray[1] = 89.00f;//2.üst
                notAraliklariArray[2] = 79.00f;//3.üst
                notAraliklariArray[3] = 69.00f;//4.üst
                notAraliklariArray[4] = 64.00f;//5.üst
                notAraliklariArray[5] = 59.00f;//6.üst
                notAraliklariArray[6] = 49.00f;//7.üst
                notAraliklariArray[7] = 29.00f;//8.üst
                notAraliklariArray[8] = 0.00f;
                break;

        }

        if (gecmeNotu <= notAraliklariArray[0] && gecmeNotu > notAraliklariArray[1]) {//100-90-0-1
            not = kisiHarfNotu.AA;
            harfinDortlukDonusumu = 4.0F;
            System.out.println("4lük karşılığı: " + not);
            System.out.println("puanı: " + harfinDortlukDonusumu);

        }else if (gecmeNotu <= notAraliklariArray[1] && gecmeNotu > notAraliklariArray[2]) {//90-84-1-3
            not = kisiHarfNotu.BA;
            harfinDortlukDonusumu = 3.5F;
            System.out.println("4lük karşılığı: " + not);
            System.out.println("puanı: " + harfinDortlukDonusumu);

        }else if (gecmeNotu <= notAraliklariArray[2] && gecmeNotu > notAraliklariArray[3]) {//84-79-3-5

            not = kisiHarfNotu.BB;
            harfinDortlukDonusumu = 3.0F;
            System.out.println("4lük karşılığı: " + not);
            System.out.println("puanı: " + harfinDortlukDonusumu);

        }else if (gecmeNotu <= notAraliklariArray[3] && gecmeNotu > notAraliklariArray[4]) {//70-60-7-9

            not = kisiHarfNotu.CB;
            harfinDortlukDonusumu = 2.5F;
            System.out.println("4lük karşılığı: " + not);
            System.out.println("puanı: " + harfinDortlukDonusumu);

        }else if (gecmeNotu <= notAraliklariArray[4] && gecmeNotu > notAraliklariArray[5]) {//60-55-9-11

            not = kisiHarfNotu.CC;
            harfinDortlukDonusumu = 2.0F;
            System.out.println("4lük karşılığı: " + not);
            System.out.println("puanı: " + harfinDortlukDonusumu);

        }else if (gecmeNotu <= notAraliklariArray[5] && gecmeNotu > notAraliklariArray[6]) {//55-50-11-13
           if(kisininOkuluString.equals("İstanbul Topkapı Üniversitesi")){
               not = kisiHarfNotu.DC;
               harfinDortlukDonusumu = 1.5F;
               System.out.println("4lük karşılığı: " + not);
               System.out.println("puanı: " + harfinDortlukDonusumu);

           }else {
               not = kisiHarfNotu.DD;
               harfinDortlukDonusumu = 1.5F;
               System.out.println("4lük karşılığı: " + not);
               System.out.println("puanı: " + harfinDortlukDonusumu);
           }

        }else if (gecmeNotu <= notAraliklariArray[6] && gecmeNotu > notAraliklariArray[7]) {//50-40-13-15
            if(kisininOkuluString.equals("İstanbul Topkapı Üniversitesi")) {
                not = kisiHarfNotu.DD;
                harfinDortlukDonusumu = 1.0F;
                System.out.println("4lük karşılığı: " + not);
                System.out.println("puanı: " + harfinDortlukDonusumu);
            }else {
                not=kisiHarfNotu.FD;
                harfinDortlukDonusumu = 0.5F;
                System.out.println("4lük karşılığı: "+not);
                System.out.println("puanı: "+harfinDortlukDonusumu);
            }
        }else if (gecmeNotu <= notAraliklariArray[7]  && gecmeNotu > notAraliklariArray[8]) {//40-0-15-17
            if(kisininOkuluString.equals("İstanbul Topkapı Üniversitesi")) {
                not = kisiHarfNotu.FD;
                harfinDortlukDonusumu = 0.5F;
                System.out.println("4lük karşılığı: " + not);
                System.out.println("puanı: " + harfinDortlukDonusumu);
            }  else {
                not=kisiHarfNotu.FF;
                harfinDortlukDonusumu = 0.0F;
                System.out.println("4lük karşılığı: "+not);
                System.out.println("puanı: "+harfinDortlukDonusumu);
            }

        }else if (gecmeNotu < notAraliklariArray[8]  && gecmeNotu >= notAraliklariArray[9]) {//40-0-15-17
            if(kisininOkuluString.equals("İstanbul Topkapı Üniversitesi")) {
                not = kisiHarfNotu.FF;
                harfinDortlukDonusumu = 0.0F;
                System.out.println("4lük karşılığı: " + not);
                System.out.println("puanı: " + harfinDortlukDonusumu);
            }else {
                if(gecmeNotu==0){
                    not=kisiHarfNotu.FF;
                    harfinDortlukDonusumu = 0.0F;
                    System.out.println("4lük karşılığı: "+not);
                    System.out.println("puanı: "+harfinDortlukDonusumu);
                }else {
                    System.out.println("HATALI Not girişi:" + gecmeNotu);
                }
            }
        }else {
                System.out.println("HATALI Not girişi:"+gecmeNotu);
        }

        return harfinDortlukDonusumu;
    }
}
