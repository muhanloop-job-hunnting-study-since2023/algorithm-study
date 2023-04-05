package week_13_230326_030401.inho;
import java.util.*;
public class Solution {
	
  
    public int[] solution(String[][] places) {
        int[] answer = new int[5];//{};
        for(int i =0; i<5; ++i) {
        	// check �޼��� �����ʿ�
        	String[] a =places[i];
        	if(check(a)) {
        		answer[i] = 1;
        	}else {
        		answer[i] = 0;
        	}
        }
        return answer;
    }
    
    
    boolean check(String[] place) {
    	for(int r= 0 ; r< 5 ; ++r) {
    		for(int c =0; c<5 ; ++c) {
    			if(place[r].charAt(c) == 'P') {
    				
    				//boolean ��ȯ�ϴ� bfs 
    				//1 �������� 
    				if(bfs(place,r,c)==false) {
    					return false;
    				}
    			}
    		}
    	}
    	// loop �ٵ��Ƶ� �̻����.
    	return true; 
    }
    // bfs ����ȭ ���� Ŭ��������
    class Point {
    	Point(int r, int c, int d ){
    		row = r;
    		col = c;
    		dist = d;
    	}
    	int row,col,dist;
    }
    //2���� �����¿� - ���ǰ��� ���̹Ƿ� 
    int [][] D = { {-1,0},{1,0},{0,-1},{0,1}};
    
    // bfs
    boolean bfs(String[] place, int row,int col) {
    	boolean[][] visited = new boolean[5][5];
    	Queue<Point> q = new LinkedList<>();
    	//���
    	visited[row][col]= true;
    	q.add(new Point(row, col, 0));
    	while(!q.isEmpty()) {
    		Point curr= q.remove();
    		if(curr.dist>2)continue;
    		if(curr.dist!=0 && place[curr.row].charAt(curr.col) == 'P') {
    			return false;
    		}
    		
    		//�����¿����
    		for(int i =0;i<4;++i) {
    			int nr= curr.row + D[i][0], nc=curr.col+D[i][1];
    			
    			if(nr<0 || nr>4 || nc<0 ||nc>4 )continue;//���������°�
    			if(visited[nr][nc])continue;//��Ƶ��ǹ̾��� 
    			if(place[nr].charAt(nc)=='X')continue;//��Ƽ���� ������
    			//��μ�. visted check.
    			visited[nr][nc] = true;
    			q.add(new Point(nr,nc,curr.dist+1));
    			
    		}
    	}//END while. 
    	return true;//�ڸ��� �� ����
    	
    }//END bfs 
    

}//END
