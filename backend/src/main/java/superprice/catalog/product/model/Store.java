package superprice.catalog.product.model;

public enum Store {
    COLES,
    WOOLWORTHS,
    ALDI;

    public static Store fromString(String str) {
        if (str.equals("Coles")) {
            return COLES;
        } else if (str.equals("Woolworths")) {
            return WOOLWORTHS;
        } else if (str.equals("Aldi")) {
            return ALDI;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
