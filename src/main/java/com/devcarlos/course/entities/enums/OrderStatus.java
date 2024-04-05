package com.devcarlos.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	SHIPPED(2),
	DELIVERED(3),
	CANCELED(4),
	PAID(5);
    
	private int code;
	private OrderStatus(int code) {
		this.code= code;
	}
     public int getCode() {
    	 return code;
     }
     
     public static OrderStatus valueOf(int code) { // vou passar um codigo e o order status vai me passr um order corespondente a esse codigo
      
    	 for(OrderStatus value : OrderStatus.values()) {
    		
    		 if (value.getCode() == code) {
    			 return value;
    		 }
    	 }
    	 throw new IllegalArgumentException("ivalid order code");
    	 
     
     }
}
