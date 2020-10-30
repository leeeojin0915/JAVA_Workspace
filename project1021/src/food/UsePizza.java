class UsePizza{
	//피자를 먹는다
	public void eat(Pizza p){
		p.slice=3;
	}
	//갯수를 조정한다
	public void setSlice(int slice){
		slice=3;
	}
	public static void main(String[] args){
		Pizza P1=new Pizza("피자헛");
		Pizza p2=new Pizza("도미노");
		UsePizza up=new UsePizza();

		up.setSlice(5); //피자들과 상관x
		up.setSlice(p1.slice);//피자헛 영향 x
		up.eat(p2);
		
	}

}
