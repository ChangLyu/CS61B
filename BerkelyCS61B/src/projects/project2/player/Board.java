package projects.project2.player;
// defined by myself
public class Board {
	square[][] squares;
	int size;
	
	public Board(){
		size=8;
		squares=new square[size][size];
		for(int x=0; x<size; x++){
			for(int y=0; y<size;y++){
				squares[size][size].occupied=false;
			}
		}
	}
	

}
