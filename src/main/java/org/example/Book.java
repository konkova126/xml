package org.example;

public class Book {
    private String shop;
    private int number;
    private String name;
    private String author;
    private int page;
    private String genre;
    private int amount;
    private String house;
    private int weight;
    private int curculation;
    private int year;
    private Price price = new Price();

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCurculation() {
        return curculation;
    }

    public void setCurculation(int curculation) {
        this.curculation = curculation;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Price getPrice() {
        return price;
    }

    public static class Price {
        private Double value;
        private String currency;

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "shop='" + shop + '\'' +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", page=" + page +
                ", genre='" + genre + '\'' +
                ", amount=" + amount +
                ", house='" + house + '\'' +
                ", weight=" + weight +
                ", curculation=" + curculation +
                ", year=" + year +
                ", price=" + price.getValue() + " " + price.getCurrency() +
                '}';
    }
}
