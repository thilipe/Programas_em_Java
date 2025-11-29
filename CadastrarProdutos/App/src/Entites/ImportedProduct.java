package Entites;
import java.util.Locale;

public class ImportedProduct extends Product{
    private double customsFee;

    public ImportedProduct(double customsFee) {
        this.customsFee = customsFee;
    }

    public ImportedProduct(String name, double price, double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag(){
        return String.format(Locale.US,"%s $ %.2f (customsFee: $ %.2f)",getName(), totalPrice(), customsFee );
    }

    public double totalPrice(){
        return getPrice() + customsFee;
    }
}
