/**
 *
 *  @author Grzechnik Mariusz S14456
 *
 */

package zad2;
 
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
 
public class Main {
 
    public static void main(String[] args) {
        Purchase purch = new Purchase("komputer", "nie ma promocji", 3000.00);
        System.out.println(purch);
 
        purch.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("Change value of: " + evt.getPropertyName() + " from: " + evt.getOldValue() + " to: " + evt.getNewValue() );
            }
        });
 
        purch.addVetoableChangeListener(new VetoableChangeListener() {
            @Override
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                if ((double)evt.getNewValue() < 1000) {
                    throw new PropertyVetoException("Price change to: " + evt.getNewValue() + " not allowed", evt);
                }
            }
        });
 
        try {
            purch.setData("w promocji");
            purch.setPrice(2000.00);
            System.out.println(purch);
            purch.setPrice(500.00);
        } catch (PropertyVetoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(purch);
    }
}
