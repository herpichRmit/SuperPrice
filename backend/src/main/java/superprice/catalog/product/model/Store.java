package superprice.catalog.product.model;

public enum Store {
    COLES,
    WOOLWORTHS,
    ALDI;

    public static Store fromString(String str) {
        if (str.equals("COLES")) {
            return COLES;
        } else if (str.equals("WOOLWORTHS")) {
            return WOOLWORTHS;
        } else if (str.equals("ALDI")) {
            return ALDI;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
