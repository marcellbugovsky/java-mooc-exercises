/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author Marcell
 */
public class ProductContainer extends Container {
    private String name;
    
    public ProductContainer(String productName, double capacity) {
        super(capacity);
        this.name = productName;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.name + ": " + super.toString();
    }
    
}
