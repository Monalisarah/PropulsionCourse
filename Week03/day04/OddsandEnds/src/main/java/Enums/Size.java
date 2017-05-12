package Enums;

public enum Size {
	
	S, M, L, XL, XXL;
	
	
	public double getSurchargePercentage(){
		switch(this){
		case XL:
			return 0.05;
		case XXL:
			return 0.1;
		default:
			return 0;
		}
		
	}
	
	
	
}


//public enum ProductSize {
//    S(0), // new ProductSize(0) some equal
//    M(0), // this does JAVA for me:  public static final ProductSize M = new ProductSize(0);
//    L(0),
//    XL(0.05f),
//    XXL(0.1f);
//    
//    private final float priceIncrease; // field "property of this class"
//    
//    private ProductSize(float size) { //constroctor for enum
//        this.priceIncrease = size;
//    }
//    public float getSurchargePercentage() {
//        return this.priceIncrease;
//    }
//    
}