public class Book11 {
    private String code;
    private String title;
    private int year;

    public Book11(String code, String title, int year) {
        this.code = code;
        this.title = title;
        this.year = year;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public void displayBook() {
        System.out.printf("| %-10s | %-25s | %-6d |\n", code, title, year);
    }
}