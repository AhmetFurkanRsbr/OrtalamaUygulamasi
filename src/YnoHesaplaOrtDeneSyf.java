import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class YnoHesaplaOrtDeneSyf {
    ArrayList<Component> ortDeneSayfasindakiComponentler = new ArrayList<>();
    ArrayList<JTextField> vizeNotlariAR=new ArrayList<>();
    ArrayList<JTextField> finalNotlariAR=new ArrayList<>();
    ArrayList<JSpinner> aktslerAR=new ArrayList<>();
    ArrayList<JTextField> vizeEtkiOranlariAR =new ArrayList<>();
    ArrayList<JTextField> finalEtkiOranlariAR=new ArrayList<>();

    static int dersSayisi=0;
    float dersGecmeNotuOrtDene=0.00f;
    float ortalamaToplamlari4luk_OrtalamaDene=0.00f;
    float ortalamaToplamlari100luk_OrtalamaDene=0.00f;
    int aktsToplamlariOrtDene=0;
    static float yno100lukOrtDene=0.00f;
    static float yno4lukOrtDene=0.00f;
    float derstenGecmeNotu4lukHarfKarsiligi=0.00f;

  YnoHesaplaOrtDeneSyf(int dersSayisi,ArrayList vizeNotlariAr,ArrayList finalNotlariAr,ArrayList finalEtkiOranlariAr,ArrayList vizeEtkiOranlariAr,ArrayList aktslerAr,ArrayList<Component> ortDeneSayfasindakiComponentlerAr){

       ortDeneSayfasindakiComponentler.clear();
       vizeNotlariAR.clear();
       finalNotlariAR.clear();
       vizeEtkiOranlariAR.clear();
       finalEtkiOranlariAR.clear();
       aktslerAR.clear();

      YnoHesaplaOrtDeneSyf.dersSayisi=dersSayisi;
        vizeNotlariAR=vizeNotlariAr;
        finalNotlariAR=finalNotlariAr;
        vizeEtkiOranlariAR=vizeEtkiOranlariAr;
        finalEtkiOranlariAR=finalEtkiOranlariAr;
        aktslerAR=aktslerAr;
        ortDeneSayfasindakiComponentler=ortDeneSayfasindakiComponentlerAr;

        ynoHesapla();
  }
  void dizilereGerekliVerileriEkle(int dersSayisi,String birim){

        JTextField anlik;
        JSpinner anlik2;

        int anlikIndex=1;
        int uzunluk=0;
        String ifade="";
        ArrayList dizi = null;
        switch (birim){
            case "vize":
                ifade="numberFld_vize";
                uzunluk=15;
                dizi=vizeNotlariAR;
                break;
            case "final":
                ifade="numberFld_final";
                uzunluk=16;
                dizi=finalNotlariAR;
                break;
            case "akts":
                ifade="spn_ortalamaDeneAkts";
                uzunluk=21;
                dizi=aktslerAR;
                break;
            case "vizeEtki":
                ifade="numberFld_vizeEtki";
                uzunluk=19;
                dizi=vizeEtkiOranlariAR;
                break;
            case "finalEtki":
                ifade="numberFld_finalEtki";
                uzunluk=20;
                dizi=finalEtkiOranlariAR;
                break;
            default:
                break;
        }

        for(Component anlikComponent : ortDeneSayfasindakiComponentler ){

            try {
                anlik = (JTextField) anlikComponent;

                if(anlikComponent.getName().toString().startsWith(ifade) && !anlik.getText().isEmpty() && anlikComponent.getName().length()-uzunluk<=2){
                    dizi.add(anlik);

                }
            }catch (ClassCastException e){
                anlik2= (JSpinner) anlikComponent;

                if(anlikComponent.getName().toString().startsWith(ifade) &&  anlikComponent.getName().endsWith(String.valueOf(anlikIndex)) && anlikIndex<=dersSayisi){
                    if(dersSayisi!=11 && anlikComponent.getName().endsWith("11")){
                        //System.out.println("akts degeri-> "+anlik2.getValue().toString());
                        //System.out.println(anlikComponent.getName()+" eklendi");
                        dizi.add(anlik2);
                        //System.out.println("ders sayısı 11 iken eklendi");
                    }else {
                        //System.out.println("akts degeri-> "+anlik2.getValue().toString());
                        //System.out.println(anlikComponent.getName()+" eklendi");
                        dizi.add(anlik2);

                        anlikIndex++;
                    }

                }
                // System.out.println(e.getMessage());
            }

        }

    }
    public void ynoHesapla(){


        vizeNotlariAR.clear();
        finalNotlariAR.clear();
        vizeEtkiOranlariAR.clear();
        finalEtkiOranlariAR.clear();
        aktslerAR.clear();


        dizilereGerekliVerileriEkle(dersSayisi,"vize");
        dizilereGerekliVerileriEkle(dersSayisi,"final");
        dizilereGerekliVerileriEkle(dersSayisi,"akts");
        dizilereGerekliVerileriEkle(dersSayisi,"vizeEtki");
        dizilereGerekliVerileriEkle(dersSayisi,"finalEtki");
                /*
                     System.out.println("vizeNotları eleman sayısı:"+vizeNotlariAR.size());
                     System.out.println("finalNotları eleman sayısı:"+finalNotlariAR.size());

                      for(int index=0;vizeNotlariAR.size()>index;index++){
                          String lblIsim = vizeNotlariAR.get(index).getName().toString();
                          int lblVeri = Integer.parseInt(vizeNotlariAR.get(index).getText());
                          System.out.println(index+".index"+lblIsim +"->:"+lblVeri);
                      }

                    for(int index=0;finalNotlariAR.size()>index;index++){
                        String lblIsim2 = finalNotlariAR.get(index).getName().toString();
                        int lblVeri2 = Integer.parseInt(finalNotlariAR.get(index).getText());
                        System.out.println(index+".index"+lblIsim2 +"->:"+lblVeri2);
                    }
                */

        for(int index=0;dersSayisi>index;index++) {

            int vizeNot;
            vizeNot = Integer.parseInt(vizeNotlariAR.get(index).getText());
            int finalNot;
            finalNot = Integer.parseInt(finalNotlariAR.get(index).getText());
            float finalEtkiOran;
            finalEtkiOran = (float) (Float.parseFloat(finalEtkiOranlariAR.get(index).getText()) /100.00);
            float vizeEtkiOran;
            vizeEtkiOran = (float) (Float.parseFloat(vizeEtkiOranlariAR.get(index).getText()) / 100.00);

                       /*
                        System.out.println("vizeNOt: "+vizeNot);
                        System.out.println("finalNOt: "+finalNot);
                        System.out.println("vizeEktiOran: "+vizeEtkiOran);
                        System.out.println("finalEktiOran: "+finalEtkiOran);
                         */

            dersGecmeNotuOrtDene = (vizeNot * vizeEtkiOran ) +  (finalNot *  finalEtkiOran);
            //System.out.println((index+1)+".ders geçme notu: "+dersGecmeNotuOrtDene);
            OkulHarfNotlari okulHarfNotlari=new OkulHarfNotlari();
            derstenGecmeNotu4lukHarfKarsiligi = okulHarfNotlari.dortlukSistemdeOrtalamaDonustur(dersGecmeNotuOrtDene,AktifKullanici.aktifKullaniciOkul);

            ortalamaToplamlari4luk_OrtalamaDene+=(derstenGecmeNotu4lukHarfKarsiligi)*(Integer.parseInt(aktslerAR.get(index).getValue().toString()));
            ortalamaToplamlari100luk_OrtalamaDene+=(dersGecmeNotuOrtDene)*(Integer.parseInt(aktslerAR.get(index).getValue().toString()));


            aktsToplamlariOrtDene += Integer.parseInt(aktslerAR.get(index).getValue().toString());

        }
        yno4lukOrtDene = ortalamaToplamlari4luk_OrtalamaDene / aktsToplamlariOrtDene;
        yno100lukOrtDene = ortalamaToplamlari100luk_OrtalamaDene / aktsToplamlariOrtDene;

    }

}
