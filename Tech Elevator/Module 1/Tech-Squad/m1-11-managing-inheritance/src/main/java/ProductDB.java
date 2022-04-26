public class ProductDB {

    public static Product getProduct(String productCode) {
        // In a more realistic application, this code would
        // get the data for the product from a file or database
        // For now, this code just uses if/else statements
        // to return the correct product data

        Product p = null;

        if (productCode.equalsIgnoreCase("java")
                || productCode.equalsIgnoreCase("jsp")
                || productCode.equalsIgnoreCase("mysql")) {
            Book b = new Book();
            if (productCode.equalsIgnoreCase("java")) {
                b.setCode(productCode);
                b.setDescription("Java Programming");
                b.setPrice(57.50);
                b.setAuthor("Joel M");
            } else if (productCode.equalsIgnoreCase("jsp")) {
                b.setCode(productCode);
                b.setDescription("Java Servlets and JSP");
                b.setPrice(57.50);
                b.setAuthor("Mike U");
            } else if (productCode.equalsIgnoreCase("mysql")) {
                b.setCode(productCode);
                b.setDescription("MySQL Bible");
                b.setPrice(54.50);
                b.setAuthor("Joel M");
            }
            p = b; // set Product object equal to the Book object
        } else if (productCode.equalsIgnoreCase("netbeans")) {
            Software s = new Software();
            s.setCode("netbeans");
            s.setDescription("NetBeans");
            s.setPrice(0.00);
            s.setVersion("8.2");
            p = s; // set Product object equal to the Software object
        }
        return p;
    }
}
