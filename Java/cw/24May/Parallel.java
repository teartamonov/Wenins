import java.awt.*;
class Parallel implements Runnable{
PIc pic;
Parallel(PIc pic) { 
this.pic = pic;
}
@Override
public void run(){
	try{
		Thread.sleep(5000);
	}
	catch(Exception e){
		return;
		}
	for(int i = 0; i < 500; i++){
		pic.angle += 10;
		pic.repaint();
		try{
		Thread.sleep(5);
	}
	catch(Exception e){
		return;
		}
}
}
}
