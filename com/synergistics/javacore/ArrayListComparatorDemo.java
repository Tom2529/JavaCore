package com.synergistics.javacore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Product{
    String brandName;
    String product;
    int rating;

    public Product(String brandName, String product, int rating) {
        this.brandName = brandName;
        this.product = product;
        this.rating = rating;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getProduct() {
        return product;
    }

    public int getRating() {
        return rating;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "brandName='" + brandName + '\'' +
                ", product='" + product + '\'' +
                ", rating=" + rating +
                '}';
    }
}

public class ArrayListComparatorDemo {

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Apple","Mobile",5));
        productList.add(new Product("Samsung","Mobile",4));
        productList.add(new Product("Nokia","Mobile",3));

        //Doing a sort on the ArrayList using Comparator ascending order
        Collections.sort(productList, Comparator.comparing(Product::getRating));
        System.out.println(productList.toString());

        //Doing a sort on the ArrayList using Comparator descending order
        Collections.sort(productList, Comparator.comparing(Product::getRating).reversed());
        System.out.println(productList.toString());

    }
}
