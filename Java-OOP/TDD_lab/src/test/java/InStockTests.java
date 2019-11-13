import java.util.*;
import java.util.stream.StreamSupport;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InStockTests {
    private ProductStock inStock;

    @Before
    public void initInStock() {
        this.inStock = new Instock();
    }

    @Test
    public void addMethodShouldAddProductCorrectly() {
        Product product = createProducts(1).get(0);
        this.inStock.add(product);
        Assert.assertTrue(this.inStock.contains(product));
    }

    @Test
    public void containsMethodShouldReturnFalseIfItemNotExsist() {
        Product product = createProducts(1).get(0);

        Assert.assertFalse(this.inStock.contains(product));
    }

    @Test
    public void containsMethodShouldReturnTrueIfItemIsContained() {
        Product product = createProducts(1).get(0);
        this.inStock.add(product);

        Assert.assertTrue(this.inStock.contains(product));
    }

    @Test
    public void countMethodShouldReturnOneWhenOnlyOneElementIsInStock() {
        Product product = createProducts(1).get(0);
        this.inStock.add(product);
        int actual = this.inStock.getCount();
        Assert.assertEquals(1, actual);
    }

    @Test
    public void countMethodShouldReturnTenWhenTenElementAreInStock() {
        List<Product> products = createProducts(10);
        for (Product product : products) {
            this.inStock.add(product);
        }
        int actual = this.inStock.getCount();
        Assert.assertEquals(10, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findMethodShouldThrowAnExceptionIfTheGivenIndexIsNotPresent() {
        this.inStock.find(0);
    }

    @Test
    public void findMethodShouldReturnTheSecondAddedProductIfTheIndexIsOne() {
        List<Product> products = createProducts(3);
        for (Product product : products) {
            this.inStock.add(product);
        }

        String expected = products.get(1).getLabel();
        String actual = this.inStock.find(1).getLabel();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findMethodShouldReturnTheFifthAddedProductIfTheIndexIsFour() {
        List<Product> products = createProducts(6);
        for (Product product : products) {
            this.inStock.add(product);
        }

        String expected = products.get(4).getLabel();
        String actual = this.inStock.find(4).getLabel();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeQuantityMethodShouldThrowAnExceptionIfTheGivenProductIsNotPresent() {
        Product product = createProducts(1).get(0);
        this.inStock.changeQuantity(product.getLabel(), 5);
    }

    @Test
    public void changeQuantityMethodShouldChangeTheQuantityToFiveOnTheGivenProduct() {
        Product product = createProducts(1).get(0);
        this.inStock.add(product);
        this.inStock.changeQuantity(product.getLabel(), 5);
        int actual = product.getQuantity();
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void changeQuantityMethodShouldChangeTheQuantityToFiftyOnTheGivenProduct() {
        Product product = createProducts(1).get(0);
        this.inStock.add(product);
        this.inStock.changeQuantity(product.getLabel(), 50);
        int actual = product.getQuantity();
        int expected = 50;
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByLabelShouldThrowAnExceptionIfProductIsNotPresent() {
        this.inStock.findByLabel("asd");
    }

    @Test
    public void findByLabelShouldReturnTheCorrectProduct() {
        List<Product> products = createProducts(2);
        products.get(0).setLabel("A");
        products.get(1).setLabel("B");
        for (Product product : products) {
            this.inStock.add(product);
        }
        String actual = this.inStock.findByLabel("B").getLabel();
        String expected = "B";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnAnEmptyCollectionIfTheArgumentIsOutOfRange() {
        Iterable<Product> firstByAlphabeticalOrder = this.inStock.findFirstByAlphabeticalOrder(2);
        Product[] actual = StreamSupport.stream(firstByAlphabeticalOrder.spliterator(), false).toArray(Product[]::new);
        Product[] expected = new Product[0];
        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnCorrectProducts() {
        List<Product> products = createProducts(2);
        for (Product product : products) {
            this.inStock.add(product);
        }

        Iterable<Product> firstByAlphabeticalOrder = this.inStock.findFirstByAlphabeticalOrder(2);
        Product[] actual = StreamSupport.stream(firstByAlphabeticalOrder.spliterator(), false).toArray(Product[]::new);
        Product[] expected = products.stream().sorted(Comparator.comparing(Product::getLabel)).toArray(Product[]::new);
        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void findAllInPriceRangeShouldReturnEmptyCollectionIfThereAreNoProductsInThisRange() {
        Iterable<Product> firstByAlphabeticalOrder = this.inStock.findAllInRange(5, 10);
        Product[] actual = StreamSupport.stream(firstByAlphabeticalOrder.spliterator(), false).toArray(Product[]::new);
        Product[] expected = new Product[0];
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllInPriceRangeShouldReturnCorrectProducts() {
        List<Product> products = createProducts(5);
        products.get(0).setPrice(6);
        products.get(1).setPrice(10);
        products.get(2).setPrice(0);
        products.get(3).setPrice(11);
        products.get(4).setPrice(0);
        for (Product product : products) {
            this.inStock.add(product);
        }
        Iterable<Product> allInRange = this.inStock.findAllInRange(5, 10);
        Product[] actual = StreamSupport.stream(allInRange.spliterator(), false).toArray(Product[]::new);
        Product[] expected = products.stream().
                filter(product -> product.getPrice() >= 6 && product.getPrice() <= 10).sorted((f, s) -> Double.compare(s.getPrice(), f.getPrice())).toArray(Product[]::new);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllByPriceShouldReturnAnEmptyCollectionIfThereAreNoProductsWithThisPrice() {
        Iterable<Product> findAllByPrice = this.inStock.findAllByPrice(5);
        Product[] actual = StreamSupport.stream(findAllByPrice.spliterator(), false).toArray(Product[]::new);
        Product[] expected = new Product[0];
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllByPriceShouldReturnCorrectProducts() {
        List<Product> products = createProducts(5);
        products.get(0).setPrice(6);
        products.get(1).setPrice(5);
        products.get(2).setPrice(0);
        products.get(3).setPrice(5.53);
        products.get(4).setPrice(0);
        for (Product product : products) {
            this.inStock.add(product);
        }
        Iterable<Product> allByPrice = this.inStock.findAllByPrice(5.53);
        Product[] actual = StreamSupport.stream(allByPrice.spliterator(), false).toArray(Product[]::new);
        Product[] expected = products.stream().
                filter(product -> product.getPrice() == 5.53).toArray(Product[]::new);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findMostExpensiveProductsShouldThrowAnExceptionIfThereAreLessThanTheGivenCountProducts() {
        this.inStock.findFirstMostExpensiveProducts(2);
    }

    @Test
    public void findMostExpensiveProductsShouldReturnCorrectProducts() {
        List<Product> products = createProducts(5);
        products.get(0).setPrice(6);
        products.get(1).setPrice(5);
        products.get(2).setPrice(0);
        products.get(3).setPrice(5.53);
        products.get(4).setPrice(0);
        for (Product product : products) {
            this.inStock.add(product);
        }
        Iterable<Product> mostExpensive = this.inStock.findFirstMostExpensiveProducts(3);
        Product[] actual = StreamSupport.stream(mostExpensive.spliterator(), false).toArray(Product[]::new);
        Product[] expected = products.stream().limit(3).
                sorted((f, s) -> Double.compare(s.getPrice(), f.getPrice())).toArray(Product[]::new);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllByQuantityShouldReturnAnEmptyCollectionIfThereAreNoProductsWithThisQuantity() {
        Iterable<Product> findAllByQuantity = this.inStock.findAllByQuantity(5);
        Product[] actual = StreamSupport.stream(findAllByQuantity.spliterator(), false).toArray(Product[]::new);
        Product[] expected = new Product[0];
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllByQuantityShouldReturnCorrectProducts() {
        List<Product> products = createProducts(5);
        products.get(0).setQuantity(6);
        products.get(1).setQuantity(5);
        products.get(2).setQuantity(10);
        products.get(3).setQuantity(10);
        products.get(4).setQuantity(0);
        for (Product product : products) {
            this.inStock.add(product);
        }
        Iterable<Product> allByQuantity = this.inStock.findAllByQuantity(10);
        Product[] actual = StreamSupport.stream(allByQuantity.spliterator(), false).toArray(Product[]::new);
        Product[] expected = products.stream().
                filter(product -> product.getQuantity() == 10).toArray(Product[]::new);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getIterableMethodShouldReturnAllProductsInStock() {
        List<Product> products = createProducts(5);
        products.get(0).setQuantity(6);
        products.get(1).setQuantity(5);
        products.get(2).setQuantity(10);
        products.get(3).setQuantity(10);
        products.get(4).setQuantity(0);
        for (Product product : products) {
            this.inStock.add(product);
        }
        Iterator<Product> iterator = this.inStock.iterator();

        Iterable<Product> allInStock = getIterableFromIterator(iterator);
        Product[] actual = StreamSupport.stream(allInStock.spliterator(), false).toArray(Product[]::new);
        Product[] expected = products.stream().
                toArray(Product[]::new);
        Assert.assertArrayEquals(expected, actual);
    }

    public static <T> Iterable<T> getIterableFromIterator(Iterator<T> iterator) {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return iterator;
            }
        };
    }

    private List<Product> createProducts(int count) {
        List<Product> products = new ArrayList<>();

        while (count > 0) {
            Product product = new Product(UUID.randomUUID().toString(), 10.2 * count, 10 * count);
            products.add(product);
            count--;
        }
        return products;
    }
}

