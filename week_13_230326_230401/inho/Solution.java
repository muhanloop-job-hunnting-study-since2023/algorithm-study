package week_13_230326_030401.inho;
import java.util.*;
public class Solution {
	
  
    public int[] solution(String[][] places) {
        int[] answer = new int[5];//{};
        for(int i =0; i<5; ++i) {
        	// check 메서드 정의필요
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
    				
    				//boolean 반환하는 bfs 
    				//1 어겨진경우 
    				if(bfs(place,r,c)==false) {
    					return false;
    				}
    			}
    		}
    	}
    	// loop 다돌아도 이상없다.
    	return true; 
    }
    // bfs 심플화 위한 클래스생성
    class Point {
    	Point(int r, int c, int d ){
    		row = r;
    		col = c;
    		dist = d;
    	}
    	int row,col,dist;
    }
    //2차원 상하좌우 - 앞의것이 행이므로 
    int [][] D = { {-1,0},{1,0},{0,-1},{0,1}};
    
    // bfs
    boolean bfs(String[] place, int row,int col) {
    	boolean[][] visited = new boolean[5][5];
    	Queue<Point> q = new LinkedList<>();
    	//출발
    	visited[row][col]= true;
    	q.add(new Point(row, col, 0));
    	while(!q.isEmpty()) {
    		Point curr= q.remove();
    		if(curr.dist>2)continue;
    		if(curr.dist!=0 && place[curr.row].charAt(curr.col) == 'P') {
    			return false;
    		}
    		
    		//상하좌우찌르기
    		for(int i =0;i<4;++i) {
    			int nr= curr.row + D[i][0], nc=curr.col+D[i][1];
    			
    			if(nr<0 || nr>4 || nc<0 ||nc>4 )continue;//밟을수없는곳
    			if(visited[nr][nc])continue;//밟아도의미없음 
    			if(place[nr].charAt(nc)=='X')continue;//파티션임 못밟음
    			//비로소. visted check.
    			visited[nr][nc] = true;
    			q.add(new Point(nr,nc,curr.dist+1));
    			
    		}
    	}//END while. 
    	return true;//자리를 잘 지켰
    	
    }//END bfs 
    

}//END
