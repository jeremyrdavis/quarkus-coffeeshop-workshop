package org.j4k.workshops.quarkus.favfood.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;

import org.j4k.workshops.quarkus.domain.LineItem;
import org.j4k.workshops.quarkus.domain.OrderInCommand;

@ApplicationScoped
public class FavFoodOrderHandler {

    static final Set<String> beverages = new HashSet<>(Arrays.asList("CAPPUCCINO","COFFEE_BLACK","COFFEE_WITH_ROOM","ESPRESSO","ESPRESSO_DOUBLE","LATTE"));

    static final Set<String> food = new HashSet<>(Arrays.asList("CAKEPOP","CROISSANT","CROISSANT_CHOCOLATE","MUFFIN"));
    
    
    public static OrderInCommand createFromFavFoodOrder(final FavFoodOrder favFoodOrder){

        OrderInCommand orderInCommand = new OrderInCommand();

        favFoodOrder.getLineItems().forEach(favFoodLineItem -> {
            if(beverages.contains(favFoodLineItem.getItem())){
                for(int i=0;i<favFoodLineItem.getQuantity();i++){
                    orderInCommand.addBeverage(new LineItem(favFoodLineItem.getItem(), favFoodOrder.getCustomerName()));  
                }
            }else if(food.contains(favFoodLineItem.getItem())){
                for(int i=0;i<favFoodLineItem.getQuantity();i++){
                    orderInCommand.addKitchenOrder(new LineItem(favFoodLineItem.getItem(), favFoodOrder.getCustomerName()));  
                }
            }
        });
        return orderInCommand;
    }
    

}
