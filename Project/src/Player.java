
public class Player {

	String name;
	int score;
	Player(String name,int score)
	{
		this.name = name;
		this.score = score;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           Player p[] = new Player[5];
           p[0] = new Player("scarlet",10);
           p[1] = new Player("hars",100);
           p[2] = new Player("tom",30);
           p[3] = new Player("clint",0);
           p[4] = new Player("hari",100);
    
           int i,j,k,l;
           String n;
           
           for(i=0;i<4;i++)
           {
        	   for(j=i+1;j<=4;j++)
        	   {
        		 if(p[i].score<p[j].score)  
        		 {
        			p[i].score=p[i].score+p[j].score;
        			p[j].score=p[i].score-p[j].score;
        			p[i].score=p[i].score-p[j].score;
        			
					n=p[i].name;
					p[i].name=p[j].name;
					p[j].name=n;
	        		 
        		 }
        		 else
        		 {
        			 
        			 if(p[i].score == p[j].score)
        			 {
        				 l = (p[i].name).compareToIgnoreCase(p[j].name);
        				 if(l<=0)
        				 {
        					 p[i].score=p[i].score+p[j].score;
        	        		 p[j].score=p[i].score-p[j].score;
        	        		 p[i].score=p[i].score-p[j].score;
        	        		 
        	        		 n=p[i].name;
        					 p[i].name=p[j].name;
        				     p[j].name=n;
        	        		 
        				 }
        			 }
        		 }
        		 
        	   }
           }
           for(i=0;i<=4;i++)
           System.out.println(p[i].score+""+p[i].name);
           
           
	}

}
