import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.Toolkit;

import java.util.Random;

class AI {
	float [] k = new float[5];
	boolean shouldJump(float x, float y, float w, float h){
	return k[0]*x+k[1]*y+k[2]*w+k[3]*h < 0;
	}

	AI(float[] k){
		for(int i = 0; i < 5; i++){
		this.k[i] = k[i];
		}
	}
	AI(AI parent, float delta){
		Random rng = new Random();
		for(int i = 0; i < 5; i++){
			k[i] = parent.k[i]-delta+rng.nextFloat(delta*2);
		}	
	}
	
	void output(){
		for(int i = 0; i <5; i++){
		System.out.print(k[i] + "f, \n");

		
		}
	}
}	
