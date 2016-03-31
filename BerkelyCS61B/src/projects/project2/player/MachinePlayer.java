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
    return new Move();
  } 

  // If the Move m is legal, records the move as a move by the opponent
  // (updates the internal game board) and returns true.  If the move is
  // illegal, returns false without modifying the internal state of "this"
  // player.  This method allows your opponents to inform you of their moves.
  public boolean opponentMove(Move m) {
	  if(m.moveKind==Move.ADD){
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
	      // legal add action, update the board and return true
          this.board.squares[m.x1][m.y1].occupied=true;
          return true;    
	      }else if(m.moveKind==Move.STEP){
		  
	  }else{
		  
	  }
    return false;
  }

  // If the Move m is legal, records the move as a move by "this" player
  // (updates the internal game board) and returns true.  If the move is
  // illegal, returns false without modifying the internal state of "this"
  // player.  This method is used to help set up "Network problems" for your
  // player to solve.
  public boolean forceMove(Move m) {
    return false;
  }

}
