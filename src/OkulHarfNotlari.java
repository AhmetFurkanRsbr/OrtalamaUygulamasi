public class OkulHarfNotlari {
    enum TopkapiHarfNotu{
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
    TopkapiHarfNotu not;
    float harfinDortlukDonusumu;

    public float dortlukSistemdeOrtalamaDonustur(float gecmeNotu){

        if( gecmeNotu <= 100 && gecmeNotu >= 90){
            not=TopkapiHarfNotu.AA;
            harfinDortlukDonusumu=4.0F;
        } else if (gecmeNotu < 90.0F  && gecmeNotu >= 85.0F) {
            not=TopkapiHarfNotu.BA;
            harfinDortlukDonusumu=3.5F;
        } else if (gecmeNotu < 85  && gecmeNotu >= 80) {
            not=TopkapiHarfNotu.BB;
            harfinDortlukDonusumu=3.0F;
        } else if (gecmeNotu < 80  && gecmeNotu >= 70) {
            not=TopkapiHarfNotu.CB;
            harfinDortlukDonusumu=2.5F;
        } else if (gecmeNotu < 70  && gecmeNotu >= 60) {
            not=TopkapiHarfNotu.CC;
            harfinDortlukDonusumu=2.0F;
        } else if (gecmeNotu < 60  && gecmeNotu >= 55) {
            not=TopkapiHarfNotu.DC;
            harfinDortlukDonusumu=1.5F;
        } else if (gecmeNotu < 55  && gecmeNotu >= 50) {
            not=TopkapiHarfNotu.DD;
            harfinDortlukDonusumu=1.0F;
        } else if (gecmeNotu < 50  && gecmeNotu >= 40) {
            not=TopkapiHarfNotu.FD;
            harfinDortlukDonusumu=0.5F;
        } else if (gecmeNotu < 40  && gecmeNotu >= 0) {
            not=TopkapiHarfNotu.FF;
            harfinDortlukDonusumu=0.0F;
        }else {
            System.out.println("HATALI Not girişi");
        }

        return harfinDortlukDonusumu;
    }
}
