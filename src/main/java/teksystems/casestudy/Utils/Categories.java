package teksystems.casestudy.Utils;


public enum Categories {
    Ikat("Ikat"),
    Kalamakari("Kalamakari"),
    Crepe("Crepe"),
    Cotton("Cotton"),
    Velvet("Velvet"),
    PureSilk("PureSilk"),
    Denim("Denim"),
    Lenin("Lenin");

    private String category;

    Categories(String category) {this.category = category;}

    public String getValue() { return category; }

}
