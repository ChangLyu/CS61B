package projects.project2.player;

/* MachinePlayer.java */

/**
 *  An implementation of an automatic Network player.  Keeps track of moves
 *  made by both players.  Can select a move for itself.
 */
public class MachinePlayer extends Player {
	
	int color;
	int searchDepth;
	Board board;
	public final static int Black=0;
	public final static int White=1;
	int bestScore;
	boolean legal;

  // Creates a machine player with the given color.  Color is either 0 (black)
  // or 1 (white).  (White has the first move.)
  public MachinePlayer(int color) {
	  this.board=new Board();
	  
	  this.color=color;
  }

  // Creates a machine player with the given color and search depth.  Color is
  // either 0 (black) or 1 (white).  (White has the first move.)
  public MachinePlayer(int color, int searchDepth) {
	  this.color=color;
	  this.searchDepth=searchDepth;
  }

  // Returns a new move by "this" player.  Internally records the move (updates
  // the internal game board) as a move by "this" player.
  public Move chooseMove() {
	  // judge if some wined
	  if(win()){
	  return a move and bestscore;
	  }
	  
	  if( this.board.occupiedNumber<=19){
		  //this is add move and find a legal move
		  for(int i=0; i<this.board.size-1;i++){
			  for(int j=0;j<this.board.size-1;j++){
				if(forceMove( new Move(i,j))){
				// already find a legal add action, 	
				}
			  }
		  }
	  }else{
		  // this is move action
	  }
	  

	 
	  
    return new Move();
  } 

  // If the Move m is legal, records the move as a move by the opponent
  // (updates the internal game board) and returns true.  If the move is
  // illegal, returns false without modifying the internal state of "this"
  // player.  This method allows your opponents to inform you of their moves.
  public boolean opponentMove(Move m) {
	  if(m.moveKind==Move.ADD||m.moveKind==Move.STEP){
		  // four corner can not be occupied
		  if((m.x1==0&&m.y1==0)||(m.x1==this.board.size-1&&m.y1==0)
				  ||(m.x1==0&&m.y1==this.board.size-1)||(m.x1==this.board.size-1&&m.y1 ==this.board.size-1)){
			  return false;
		  }
		  // square which are already occupied can not be occupied
		  if(this.board.squares[m.x1][m.y1].occupied==true){
			  return false;
		  }
		  // opponent is white can not occupy the upper row and lower row
	      if(this.color==Black&&(m.y1==0||m.y1==this.board.size-1)){
	    	  return false;
	      }
	      // opponent is black can not occupy the left column and right column
	      if(this.color==White&&(m.x1==0||m.x1==this.board.size-1)){
	    	  return false;
	      }
	      if(m.moveKind==Move.ADD){
	     //The fourth rule : A player may not have more than two chips in a connected group, whether
	      //connected orthogonally or diagonally.
	    	if(!fourthRule(m.x1,m.y1)){
	    		return false;
	    	}
	    
	      // legal add action, update the board and return true
	    	  this.board.squares[m.x1][m.y1].occupied=true;
	    	  this.board.occupiedNumber++;
	    	  this.board.squares[m.x1][m.y1].player=this.color==White?Black:White; 
              return true;
          } else{
        	  
        	  //The fourth rule : A player may not have more than two chips in a connected group, whether
    	      //connected orthogonally or diagonally.
        	  //let the move action acts like add action for using fouthRule
        	  this.board.squares[m.x2][m.y2].occupied=false;
    	    	if(!fourthRule(m.x1,m.y1)){
    	    		//if the move is illegal, return false and change to original situation
    	      this.board.squares[m.x2][m.y2].occupied=true;	
    	    		return false;
    	    	}
        	// legal move action, update the board and return true
        	  this.board.squares[m.x1][m.y1].occupied=true;
        	  this.board.occupiedNumber++;
        	  this.board.squares[m.x1][m.y1].player=this.color==White?Black:White; 
        	  this.board.squares[m.x2][m.y2].player=-1; 
        	  return true;
             }
	  }else{
           // quit action, did not think it out yet 	
		  return false;
             }	  
	  
      }
// if all squares around this square have two occupied, then illegal. if only one, then check that one with the same method
  public boolean fourthRule(int x1, int y1){
	  int count=0;
	  int i2=0;
	  int j2=0;
	  for(int i=x1-1;i<= x1+1;i++){
		  for(int j=y1-1;j<=y1+1;j++){
			  
			  if(this.board.squares[i][j].occupied==true){
				  i2=i;
				  j2=j;
				  ++count;}
		  }}
	  if(count==2){
		  return false;
	  }else if(count==1){
		  legal=fourthRule(i2,j2);
	  }
	  return legal;
	  }
  // If the Move m is legal, records the move as a move by "this" player
  // (updates the internal game board) and returns true.  If the move is
  // illegal, returns false without modifying the internal state of "this"
  // player.  This method is used to help set up "Network problems" for your
  // player to solve.
  public boolean forceMove(Move m) {
	  
	  if(m.moveKind==Move.ADD||m.moveKind==Move.STEP){
		  // four corner can not be occupied
		  if((m.x1==0&&m.y1==0)||(m.x1==this.board.size-1&&m.y1==0)
				  ||(m.x1==0&&m.y1==this.board.size-1)||(m.x1==this.board.size-1&&m.y1 ==this.board.size-1)){
			  return false;
		  }
		  // square which are already occupied can not be occupied
		  if(this.board.squares[m.x1][m.y1].occupied==true){
			  return false;
		  }
		  // computer is white can not occupy the upper row and lower row
	      if(this.color==White&&(m.y1==0||m.y1==this.board.size-1)){
	    	  return false;
	      }
	      // computer is black can not occupy the left column and right column
	      if(this.color==Black&&(m.x1==0||m.x1==this.board.size-1)){
	    	  return false;
	      }
	      if(m.moveKind==Move.ADD){
	    	  
	    	//The fourth rule : A player may not have more than two chips in a connected group, whether
		      //connected orthogonally or diagonally.
		    	if(!fourthRule(m.x1,m.y1)){
		    		return false;
		    	}
	      // legal add action, update the board and return true
	    	  this.board.squares[m.x1][m.y1].occupied=true;
	    	  this.board.occupiedNumber++;
	    	  this.board.squares[m.x1][m.y1].player=this.color==White?White:Black; 
              return true;
          } else{
        	  
        	//The fourth rule : A player may not have more than two chips in a connected group, whether
    	      //connected orthogonally or diagonally.
        	  //let the move action acts like add action for using fouthRule
        	  this.board.squares[m.x2][m.y2].occupied=false;
    	    	if(!fourthRule(m.x1,m.y1)){
    	    		//if the move is illegal, return false and change to original situation
    	      this.board.squares[m.x2][m.y2].occupied=true;	
    	    		return false;
    	    	}
        	// legal move action, update the board and return true
        	  this.board.squares[m.x1][m.y1].occupied=true;
        	  this.board.occupiedNumber++;
        	  this.board.squares[m.x1][m.y1].player=this.color==White?White:Black; 
        	  this.board.squares[m.x2][m.y2].player=-1; 
        	  return true;
             }
	  }else{
           // quit action, did not think it out yet 	
		  return false;
             }
  }

}
