

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Instock implements ProductStock {
    private Map<String,Product> products;

    public Instock(){
        this.products = new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
       return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
       return this.products.containsKey(product.getLabel());
    }

    @Override
    public void add(Product product) {
        this.products.put(product.getLabel(),product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        if(!this.products.containsKey(product)){
            throw new IllegalArgumentException();
        }else {
            this.products.get(product).setQuantity(quantity);
        }


    }

    @Override
    public Product find(int index) {
        if(index >= this.products.size()){
            throw new IllegalArgumentException();
        }else {
            List<Product> allProducts = new ArrayList<>();
            this.products.values().forEach(product -> allProducts.add(product));
            return allProducts.get(index);
        }
    }

    @Override
    public Product findByLabel(String label) {
        if(!this.products.containsKey(label)){
            throw new IllegalArgumentException();
        }else {
            return this.products.get(label);
        }
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if(count > this.getCount()){
            return new ArrayList<>();
        }else {
            return this.products.values().stream().sorted(Comparator.comparing(Product::getLabel)).limit(count).collect(Collectors.toList());
        }
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        List<Product> products = this.products.values().stream().
                filter(product -> product.getPrice() >= lo && product.getPrice() <= hi).sorted((f, s) -> Double.compare(s.getPrice(), f.getPrice())).collect(Collectors.toList());
        if(products.isEmpty()) {
            return new ArrayList<>();
        }else {
            return products;
        }
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        List<Product> products = this.products.values().stream().filter(product -> product.getPrice() == price).collect(Collectors.toList());
        if(products.isEmpty()){
            return new ArrayList<>();
        }else {
            return products;
        }
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        List<Product> products = this.products.values().stream().limit(count).sorted((f,s)->Double.compare(s.getPrice(),f.getPrice())).collect(Collectors.toList());
        if(products.size() < count){
            throw new IllegalArgumentException();
        }else {
            return products;
        }
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        List<Product> products = this.products.values().stream().filter(product -> product.getQuantity() == quantity).collect(Collectors.toList());
        if(products.isEmpty()){
            return new ArrayList<>();
        }else {
            return products;
        }

    }

    @Override
    public Iterator<Product> iterator() {
      return this.products.values().iterator();
    }
}
