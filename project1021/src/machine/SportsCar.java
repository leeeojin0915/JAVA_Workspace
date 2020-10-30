/*class  HighHeel{
	String color="None Color";

public HighHeel(String color){
	this.color=color;
}
	public static void main(String[] args){
		HighHeel h=new HighHeel("red");
	}
}*/

class  SportsCar{
   String color="None Color";    

   public SportsCar(String color){
	   this.color=color;
   }
   
   public void setColor(String color){
	   this.color=color;
   }

   public static void main(String[] args){
	   SportsCar s=new SportsCar("black");
	   
	   //s.setColor("red");

	   System.out.println(s.color);
   }

}
