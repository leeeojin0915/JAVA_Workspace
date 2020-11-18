/*
 * 데이터간 구조화된 포함관계를 표현할때 흔히 사용되는 Tree를 배워보자
 * 
 * */
package day1117.db;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeApp extends JFrame{
	JTree tree;
	JScrollPane scroll;
	
	public TreeApp() {
		//트리에 보여질 노드를 구성
		DefaultMutableTreeNode top=new DefaultMutableTreeNode("상품목록");
		DefaultMutableTreeNode ac=new DefaultMutableTreeNode("악세사리");
		DefaultMutableTreeNode shoe=new DefaultMutableTreeNode("신발");
		top.add(ac);
		top.add(shoe);
		createNode(ac,shoe);//반지,목걸이,귀걸이,팔찌를 부착예정. 따라서 최상위 노드를 넘기자
		tree=new JTree(top);//이따가 여기에 노드를 생성자 인수로 넣어줄 예정임->최상위 노드를 생성자의 인수로 넣자
		scroll=new JScrollPane(tree);
		
		add(scroll);
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public void createNode(DefaultMutableTreeNode ac,DefaultMutableTreeNode shoe) {
		//넘겨받은 탑 노드에 원하는 하위 노드를 생성하여 자식노드로 붙이자
		DefaultMutableTreeNode[] node=new DefaultMutableTreeNode[7];
		node[0]=new DefaultMutableTreeNode("반지");
		node[1]=new DefaultMutableTreeNode("목걸이");
		node[2]=new DefaultMutableTreeNode("귀걸이");
		node[3]=new DefaultMutableTreeNode("팔찌");
		node[4]=new DefaultMutableTreeNode("구두");
		node[5]=new DefaultMutableTreeNode("운동화");
		node[6]=new DefaultMutableTreeNode("슬리퍼");
		//생성된 노드를 top노드의 하위노드로 부착
		for(int i=0;i<node.length;i++) {
			if(i<4) {
				ac.add(node[i]);				
			}else {
				shoe.add(node[i]);
			}
		}
		
	}
	public static void main(String[] args) {
		new TreeApp();
	}

}
