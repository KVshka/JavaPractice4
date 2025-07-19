public class Guitar {

    @JsonField(name = "Manufacturer")
    private String Manufacturer;

    @JsonField(name = "Model")
    private String Model;

    @JsonField(name = "Type")
    private String Type;

    @JsonField(name = "Price")
    private int Price;

    public Guitar(String Manufacturer, String Model, String Type, int Price){
        this.Manufacturer = Manufacturer;
        this.Model = Model;
        this.Type = Type;
        this.Price = Price;
    }

    @DeprecatedEx(message = "newMethod()")
    public void oldMethod() {
        System.out.println("Это старый метод");
    }

    public void newMethod() {
        System.out.println("Это новый метод");
    }
}
