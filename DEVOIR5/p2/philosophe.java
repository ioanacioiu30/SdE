/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2;

/**
 *
 * @author Ioana
 */

class philosophe extends Thread {
	/** no du philosophe */
	int no;
	/** nb de bouchees restantes dans l'assiette */
	int nbBouchees;
	/** stoppe le processus s'il a fini son assiette */
	boolean fini;
	/** date de debut du diner */
	long debut;
	/** liste de fourchettes */
	fourchettes lesFourchettes;
	/** lien vers la JFrame pour mise a jour de l'affichage*/
	LeDiner laTable;
	
	
	/** initialise fini a true*/	
	philosophe()
	{
		fini = true;
	}
	
	/** initialise le no et nb de bouchees */
	philosophe(int _no, int _nbBouchees, fourchettes _lesFourchettes, LeDiner _laTable)
	{
		no = _no;
		nbBouchees = _nbBouchees;
		lesFourchettes = _lesFourchettes;
		fini = false;
		laTable = _laTable;
	}
	
	/** fonction principale du philosophe : cycle sur manger, penser.
	 * Pour manger, il prend la fourchette de droite et celle de gauche.
	 * Donc i prend la fourchette i et i+1.<br>
	 * Le philosophe garde les fourchettes un certains temps et les depose ensuite<br>
	 * la boucle se termine lorsque le philosophe a termine ses bouchees.
	 * */
	public void run()
	{
		debut = System.currentTimeMillis();
		while(!fini)
		{
			//System.out.println("philo"+no+" : je pense en attendant les fourchettes");
			laTable.penserEtAttendre(no);
            lesFourchettes.prendre(no);
            laTable.manger(no, nbBouchees);
            //System.out.println("philo"+ no+ " : je mange, il me reste " + nbBouchees + " bouchees.");
            nbBouchees--;
            fini = (nbBouchees<=0); 
            try {	Thread.sleep((int)(Math.random()*2000));}  // 100 ms max
            catch (InterruptedException e) {}
            //System.out.println("philo"+ no+ " : je depose les fourchettes.");
            lesFourchettes.deposer(no);
            laTable.penser(no);
			//System.out.println("philo"+no+" : je pense un peu");
            try {	Thread.sleep((int)(Math.random()*2000));}  // 100 ms max
            catch (InterruptedException e) {}
		}
		long fin = System.currentTimeMillis();
		laTable.finir(no);
		//System.out.println("philo"+ no+ " : j'ai fini en " + (float)((float)(fin-debut)/1000) + "s...");

	}

   
    
}