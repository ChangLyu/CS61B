package projects.project2.player;
// defined by myself
public class Board {
	square[][] squares;
	int size;
	int occupiedNumber;
	public Board(){
		this.occupiedNumber=0;
		size=8;
		squares=new square[size][size];
		for(int x=0; x<size; x++){
			for(int y=0; y<size;y++){
				squares[size][size].occupied=false;
				squares[size][size].player=-1;
			}
		}
	}
	

}
