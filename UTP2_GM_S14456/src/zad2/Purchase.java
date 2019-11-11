/**
 *
 *  @author Grzechnik Mariusz S14456
 *
 */

package zad2;

import java.beans.*;
 
public class Purchase {
    private String prod;
    private String data;
    private double price;
 
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private VetoableChangeSupport vcs = new VetoableChangeSupport(this);
 
    public Purchase(String prod, String data, double price) {
        this.prod = prod;
        this.data = data;
        this.price = price;
    }
 
 
    public String getProd() {
        return prod;
    }
 
    public void setProd(String prod) {
        this.prod = prod;
    }
 
    public String getData() {
        return data;
    }
 
    public void setData(String data) {
        String oldData = this.data;
        this.data = data;
        pcs.firePropertyChange("data", oldData, data);
    }
 
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) throws PropertyVetoException {
        double oldPrice = this.price;
        vcs.fireVetoableChange("price", oldPrice, price);
        this.price = price;
        pcs.firePropertyChange("price", oldPrice, price);
    }
 
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
 
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
 
    public void addVetoableChangeListener(VetoableChangeListener listener) {
        vcs.addVetoableChangeListener(listener);
    }
 
    public void removeVetoableChangeListener(VetoableChangeListener listener) {
        vcs.removeVetoableChangeListener(listener);
    }
 
    @Override
    public String toString() {
        return "Purchase [" + "prod="+ prod + ", data="+data + ", price="+price + "]";
    }
}
 