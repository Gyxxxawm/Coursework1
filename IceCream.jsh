final int VanillaPrice=80;
final int ChocolatePrice=41;
final int StrawberryPrice=40;
final int ConePrice=100;
void processOrder(String flavor,int scoops){
            if ("v".equals(flavor)){
                double totalCost=ConePrice+VanillaPrice*scoops;
                System.out.printf("That will be %.2f please.",totalCost);}
            else if ("c".equals(flavor)){
                double totalCost=ConePrice+ChocolatePrice*scoops;
                System.out.printf("That will be %.2f please.",totalCost);}
            else if("s".equals(flavor)){
                double totalCost=ConePrice+StrawberryPrice*scoops;
                System.out.printf("That will be%.2f please.",totalCost);}
            else{
                System.out.println("We don't have that flavor.");
            }
}