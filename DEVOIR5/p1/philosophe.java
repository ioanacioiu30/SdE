/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

/**
 *
 * @author Ioana
 */
public class philosophe  extends Thread {
    
     
    baguette droit;
    baguette gauche;

    public philosophe(baguette droit, baguette gauche,String name) {
	this.droit=droit;
	this.gauche=gauche;
	setName(name);
    }
    public void run() {
	// ...
    }
}
    
    
    