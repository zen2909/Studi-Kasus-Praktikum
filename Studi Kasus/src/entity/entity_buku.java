package entity;

public class entity_buku {
    public String namabuku,pencipta;
    public int tahunterbit;

    public entity_buku(String namabuku, String pencipta, int tahunterbit) {
        this.namabuku = namabuku;
        this.pencipta = pencipta;
        this.tahunterbit = tahunterbit;
    }

    public String getNamabuku() {
        return namabuku;
    }

    public void setNamabuku(String namabuku) {
        this.namabuku = namabuku;
    }

    public String getPencipta() {
        return pencipta;
    }

    public void setPencipta(String pencipta) {
        this.pencipta = pencipta;
    }

    public int getTahunterbit() {
        return tahunterbit;
    }

    public void setTahunterbit(int tahunterbit) {
        this.tahunterbit = tahunterbit;
    }
}
