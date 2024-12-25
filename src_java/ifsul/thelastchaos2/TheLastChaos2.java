package br.edu.ifsul.sapucaia.thelastchaos2;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
public class TheLastChaos2 {
	  public static void main(String[] args) {
    	 UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("", Font.BOLD, 14)));
		 UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("", Font.BOLD, 12)));
		 UIManager.put("OptionPane.messageForeground", Color.BLACK);
		 UIManager.put("OptionPane.titleText", "The Last Chaos"); 
         UIManager.put("OptionPane.cancelButtonText", "Cancel");  
         UIManager.put("OptionPane.okButtonText", "Ok");
        
         
         Object[] options = {"BRIGHTSIDE", "BAD SIDE"};
		 int loop = JOptionPane.YES_OPTION;
		 int choice, points, score[] = new int[5];
		 String name, scoreName[] = new String[5];
		 
		 for(int i = 0; i <= 4; i++) {
			 score[i] = 0;
			 scoreName[i] = "------------";
		 }
	
		 JOptionPane.showMessageDialog(null, "     Welcome to ' The Last Chaos '", "GAME", JOptionPane.PLAIN_MESSAGE);
		 
		 while(loop == JOptionPane.YES_OPTION) {
			 points = 0;
			 Object character = null;
             JOptionPane.showMessageDialog(null, "- Characters\n\nBrightside: Currently, with forty-five years old, this female character has enough \nexperience in this post pandemic world, she has gone through many dangerous\nsituations and will not give up to get the world's salvation.\n\nBad side: The smartest and the most dangerous person in the world. His objective\nis to destroy the world by destroying the cure. Play with him and see how he thinks.\nYou may need to play a few times to understand it fully.", "INTRODUCTION", JOptionPane.INFORMATION_MESSAGE); 
             while(character == null) {
                 character = JOptionPane.showInputDialog(null, "Select your character:\n\n", "DECISION", JOptionPane.PLAIN_MESSAGE, null, options, null);
                 if(character == null) {
                	 JOptionPane.showMessageDialog(null, "You canceled the game.\n        GAME OVER", "WARNING", JOptionPane.ERROR_MESSAGE); 
                	 System.exit(0);
                 }
             }
             
             name = "";
             
             while(name.length() < 4 || name.length() > 8) {  // maximum and minimum char length
            	 buttons.buttons(null, null ,"Ok");
            	 name = JOptionPane.showInputDialog(null, "What's the name of your character?\n\n(Min: 4 ; Max: 8)", "QUESTION", JOptionPane.PLAIN_MESSAGE);
            	 if(name == null) {
            		 JOptionPane.showMessageDialog(null, "You canceled the game.\n        GAME OVER", "WARNING", JOptionPane.ERROR_MESSAGE); 
                	 System.exit(0);
            	 } else {
            		 if(name.length() < 4 && name.length() > 0) {
            			 JOptionPane.showMessageDialog(null, "                 Name too short!", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            		 } else if(name.length() > 8) {
            			 JOptionPane.showMessageDialog(null, "                   Name too big!", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);   
            		 } else if(name.length() == 0) {
            			 JOptionPane.showMessageDialog(null, "     Your character have no name.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
       		           }
            	   }
             }
             
		     JOptionPane.showMessageDialog(null, "In all dialog boxes, you can click in cancel and stop the game.", "WARNING", JOptionPane.WARNING_MESSAGE);

		     if(character.equals("BRIGHTSIDE")) {   // beginning brightside
        	    buttons.buttons("Lock Yourselves at Home","Seek Refuge", null);
        	    choice = JOptionPane.showConfirmDialog(null, "25 years ago...\nBoston snapped and the virus has spread. "+name+" is with her\nlittle daughter (Amy) seeking refuge.");
        	    cancel.cancel(choice);
        	    if(choice == JOptionPane.YES_OPTION || choice == JOptionPane.NO_OPTION ) { 
        	       buttons.buttons("Yes","No", null);
        	       choice = JOptionPane.showConfirmDialog(null, "Pether - Hey sister!\n"+name+" - What are you doing here?\nPether - Relax, I came here to get you to \nmy house.\n"+name+" - You risked a lot coming here.\nPether - Nothing happened,  I'm fine.\nCome on! There is safe. Do you want to go?");
        	       cancel.cancel(choice);
        	       if(choice == JOptionPane.YES_OPTION) {  // yes
        	          buttons.buttons("Wait","Go Through the Center", "Get in the Car");
        		       JOptionPane.showMessageDialog(null, "        Pether - Ok, Let's Go! I drive.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
        	           choice = JOptionPane.showConfirmDialog(null, "Pether - Oh shit! The highway traffic is stoped.\nPether - We should wait\n"+name+" - But it's too risky.\n"+name+" - We must go through the city center.\nPether - What do we do then?");
        		       cancel.cancel(choice);
                       if(choice == JOptionPane.YES_OPTION || choice == JOptionPane.NO_OPTION) {
                          buttons.buttons("Try this Way","Back", "GO");
                          JOptionPane.showMessageDialog(null, "Amy -  Infected are running towards us!\nPether - They are everywhere.\n"+name+" - We have no option. Go to\nanywhere!", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            		      choice = JOptionPane.showConfirmDialog(null, "- SIGNAL ON THE ROAD:\n  Two kilometers ahead\n   the road is blocked.");
            		      cancel.cancel(choice);
            		      if(choice == JOptionPane.YES_OPTION || choice == JOptionPane.NO_OPTION) {
            		         buttons.buttons(null, null, "...");
            		 	     JOptionPane.showMessageDialog(null, name+" - Pether, attention with the\ncar in the other direction.\nAmy - OH GOD!\nPether - The brake isn't working.\n"+name+" - SHIT!", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            		 	 
            		 	     buttons.buttons(null, null, "Get Out Of The Car");
            			     JOptionPane.showMessageDialog(null, "An accident has happened and the car has flipped...\n"+name+" - Hey daughter, let's get out of here.\nAmy - My leg hurts.\n"+name+" - Her leg is hurting a lot?\nAmy - Yes, I think that's broken\n"+name+" - Ok, we will search for her uncle.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);         		     
            			 
            			     buttons.buttons(null, null, "Pick Up the Gun and A Metal Bar");
            			     JOptionPane.showMessageDialog(null, "Amy will have to be carried on\nthe lap because she can't walk...\n\nThere are pieces of metal on the\nfloor of the car and Pether left a\ngun in the car. An infected is\napproaching.\n\n"+name+" will have to defend\nherself and her daughter.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            			     points += tutorial.tutorial();
            			     points += battle.battle();
            			 
            			     buttons.buttons(null, null, "Follow Pether");
            			     JOptionPane.showMessageDialog(null, "Pether - Give me that gun! Be careful.\n" +name+" - Amy broke her leg and is\nunconscious.\nPether - Dammit, take her in his arms\nand follow me. We're almost there, I\ncover you.\n", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            			 
            			     buttons.buttons(null, null, "Continue Following Pether");
            			     JOptionPane.showMessageDialog(null, "Pether - We will go through this alley.\n"+name+" - Care for the infected forward.\nPether - I kill him.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                         
            			     buttons.buttons(null, null, "RUN");
                             JOptionPane.showMessageDialog(null, "Pether - The shot attracted others infected.\n"+name+" - They're coming in our way.\nPether - RUN!", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            		     
                             buttons.buttons(null, null, "Get in the House");
            		         JOptionPane.showMessageDialog(null, "        Pether - They are coming.\n        "+name+" - Open the door,\n        they're still behind of us.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            		     
            		         buttons.buttons("Help Pether","Escape With Amy", null);
            		         choice = JOptionPane.showConfirmDialog(null, "Pether - They're forcing the door, it will down\nand they will come.");
            		         cancel.cancel(choice);
            		         if(choice == JOptionPane.YES_OPTION) {  // help pether
            		            buttons.buttons(null, null, "Pick Up All");
            		            JOptionPane.showMessageDialog(null, name+" - I will help you.\nPether - Put on Amy in my bed\nand pick up my other gun on\nthe table, there's a piece of \nmetal leaning against the wall\nas well.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            		            buttons.buttons(null, null, "Ok");
            		            JOptionPane.showMessageDialog(null, "Pether - They are weaker now, \ni think there are five of them.\n"+name+" - We need to kill them.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            		            
            		            JOptionPane.showMessageDialog(null, "          Pether - Are you ready?\n          The door will down.\n          "+name+" - Here we go!","The Last Chaos", JOptionPane.PLAIN_MESSAGE);

            		            JOptionPane.showMessageDialog(null, "The door has dropped...\nPether - An infected is coming\nin your direction. I kill others\n"+name+" - I see him.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                points += battle.battle();
            		            
                                JOptionPane.showMessageDialog(null, "Pether - Be careful, another infected \nis going your direction.\n"+name+" - Oh shit!","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                points += battle.battle();
                                
                                buttons.buttons(null, null, "Try to Save Pether");
                                JOptionPane.showMessageDialog(null, name+" - They attacked you, Pether. You're\nbleeding so much.\nPether - Let me here, an infected is going\ntowards my room where Amy is.\n"+name+" - I can't leave you here to die.\nPether -  I'm losing a lot of blood. I will die\nanyway","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                
                                buttons.buttons(null, null, "Go to Amy");
                                JOptionPane.showMessageDialog(null, "Amy is crying...\nPether - Go to see that's happening\non with Amy.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                
                                buttons.buttons(null, null, "Kill Him");
                                JOptionPane.showMessageDialog(null, name+" - NO, Amy has died. Infected,\nson of a bitch.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                
                                buttons.buttons(null, null, "Go to Pether");
                                JOptionPane.showMessageDialog(null, "      Pether - "+name+", come here.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);

                                buttons.buttons(null, null, "...");
                                JOptionPane.showMessageDialog(null, "Pether - I will not survive.  I'll bleed to death\n"+name+" - But, there has to be a way to save\nyou.\nPether - Don't try anything, it's a waste of time.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                
                                buttons.buttons(null, null, "Kill Pether");
                                JOptionPane.showMessageDialog(null, "Pether - Take the gun and kill me.\nPut a stop to it.\n"+name+" - No.\nPether - PUT A STOP TO IT! NOW!","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                
                                buttons.buttons(null, null, "Commit Suicide");
                                JOptionPane.showMessageDialog(null, name+" -  I'm without my daughter, my brother's death and\nat this point, all those who are close to me, probably has\ndied. \n\nThere isn't reason to keep this life.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                points += end.end(2);
                                
            		         } else {  // escape with amy
            		        	 buttons.buttons(null, null, "Ok");
            		        	 JOptionPane.showMessageDialog(null, "Amy woke up...\nAmy - What's happening?\n"+name+" - Nothing daughter, it's all fine.\nI will take her to a safe place.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                 
            		        	 JOptionPane.showMessageDialog(null, "A police officer is just ahead...\nPolice Officer - You two, freeze.\n"+name+" - My daughter's with the\ninjured leg. We need help.\nPolice Officer - Wait here.\nAmy - Mom,  I'm afraid.\n"+name+" - Calm daughter, we'll be\nfine.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);

            		        	 JOptionPane.showMessageDialog(null, "The officer spoke to his commander and was ordered\nto kill all, because there are chance of being infected...\nPolice Officer - I can't do anything.\n"+name+" - Please, help us.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                 
            		        	 buttons.buttons(null, null, "...");
            		        	 JOptionPane.showMessageDialog(null, "The cop shot "+name+" and Amy, Peter arrived in time\nand killed the police officer, you were unharmed, but\nAmy was shot and died...\n\n"+name+" - My daughter, NO.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);

            		        	 JOptionPane.showMessageDialog(null, "25 years later...\n"+name+" is currently living with a man named  Ryan , both\nbecame contrabandists and  extremely cold because of\nthis  post-pandemic   world   where  humans  are  more\ndangerous than those infected (currently the infected\nare  classified  as  runners and  worms).  Both  didn't\nhesitate to kill their enemies when necessary.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            		             
            		        	 JOptionPane.showMessageDialog(null, " Carol  has always made several deals with (name) and  Ryan ,\nbut this time she want to propose something different...\n\n Carol  - We go to a quiet place, here on this street there are\nmany people. Follow me.\n Ryan , "+name+" - Alright", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                 
            		        	 buttons.buttons("Yes", "No", "Ok");
            		        	 choice = JOptionPane.showConfirmDialog(null, " Carol  - We arrived at my home.\n"+name+" - So, what's your proposal to us?\n Carol  - This time don't want you smuggle weapons,\nlike the last time.I want you to carry a girl to a base\nof my group in congress in Pittsfield and in return\nyou will receive many weapons and supplies for a\nyear and a half. Do you accept?");
            		        	 cancel.cancel(choice);
            		        	 if(choice == JOptionPane.YES_OPTION) {  // accept the proposal
            		        		 buttons.buttons(null, null, "Ok");
            		        		 JOptionPane.showMessageDialog(null, name+" - We accept.\n Carol  - I will present them the girl that\nyou will have to carry to congress.\n"+name+",  Ryan  - Call her.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
     
            		        		 JOptionPane.showMessageDialog(null, " Carol  - Well, she is Samantha and is fifteen\nyears old. Say hello to your new friends Samantha.\nSamantha -  I don't want to go with them.\n Carol  - But you need to go, it's very important that\nyou go. Remember what I told you.\nSamantha - Ok,  I'll.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);

            		        		 JOptionPane.showMessageDialog(null, " Carol  - You have to go fast, before\ndark and the quarantine zone guards\nprevent them from leaving.\n Ryan  - Let's go, "+name+".\n"+name+" - Follow us, Samantha.\nSamantha - Tell me the way.\n","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                     
            		        		 JOptionPane.showMessageDialog(null, "After 1 month on the way to Congress,\nSamantha begins to have more intimacy\nwith "+name+" and  Ryan .\nSamantha - You can call me to Sam!\n"+name+" - Ok, we let's start calling you to so.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);

            		        		 buttons.buttons(null, null, "Attack the Infected");
            		        		 JOptionPane.showMessageDialog(null, "2 weeks later..\n Ryan  - Silence.\n"+name+" - Infected are just ahead.\n Ryan  - We will have to face them,\nthere's no other way.\n"+name+" - Prepare your weapons\nand we will.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                     points += battle.battle();
                                     
                                     buttons.buttons(null, null, "Ok");
                                     JOptionPane.showMessageDialog(null, " Ryan  - All clear. are you fine?\n"+name+" -  I'm fine, and you?\n Ryan  - Wait... Where is Sam?\n"+name+" - We lost her.\nSam - No, I was  inside a house near\nhere, had magazines there.\n"+name+" - Don't make this, it's not safe.\nSam - Sorry","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                    
                                     JOptionPane.showMessageDialog(null, "They arrived to the congress...\n Ryan  - What the hell are happened here?\n"+name+" - They are all dead.\nSam - Oh shit!","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
 
                                     buttons.buttons(null, null, "..."); 
                                     JOptionPane.showMessageDialog(null, " Ryan  - Maybe some group of survivors of the region discovered\nthis camp and killed them to steal their weapons and supplies.\n"+name+" - Maybe some people have survived, my brother Pether\nwas a member of Flies, maybe he knows they are.\n Ryan  - He doesn't live far away?\n"+name+" - Yes, but we get here, we can go there also.\nSam - Ok, but before we go, I have to confess something ...  I'm infected.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);

                                     JOptionPane.showMessageDialog(null, name+" - You're infected?\nSam - Yes, but it's different,  I'm infected to 3 weeks.\n"+name+" - Impossible, people infected, are transformed in 2 days.\n Ryan  - Maybe true "+name+",  Carol  said it was important to bring her\nback here, perhaps this is the reason.\n"+name+" -  I don't think that's it.\n Ryan  - Why else  Carol  reason would have us bring it here?.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
          
                                     JOptionPane.showMessageDialog(null, " Ryan  - By the way,Ialso have to confess something,  I'm\nalso infected.\n"+name+" - Why not told before? How long does it infected?\n Ryan  - Less than one day.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                     
                                     buttons.buttons(null, null, "Get Out of Here"); 
                                     JOptionPane.showMessageDialog(null, "A group of survivors is invading the Congress...\n Ryan  - Go talk to your brother, and then go to search for the flies. I stay\nhere as bait for these survivors.\n"+name+" - I can't just leave you here to die\nSam - "+name+", we have to go\n Ryan  - Promise me one thing... Do you will take this girl to the flies, right?\n"+name+" - Ok, I promise.\n Ryan  - Go fast, before they enter here.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
   		        		 
                                     buttons.buttons(null, null, "Ok"); 
                                     JOptionPane.showMessageDialog(null, "Sam -I feel bad for letting  Ryan  there.\n"+name+" - I too...I too...\nSam - will they would kill him?\n"+name+" - It makes no difference, he\nwould die anyway, he was infected.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
 
                                     JOptionPane.showMessageDialog(null, "Some infected are at a more advanced stage and began\nexpelling poisonous spores, "+name+" and Sam have gone\nthrough numerous groups of them, and "+name+" realized\nthat Sam really is immune, since she has not suffered any\ndamage to breathe these spores, and "+name+" had to wear\nmasks.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);

                                     JOptionPane.showMessageDialog(null, "After long months battling infected, fleeing from cannibals, "+name+"\nand Sam have created a very strong relationship, and they reached\nof Pether's house...", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);

                                     JOptionPane.showMessageDialog(null, "Pether - Hi, sister. Long time no see you, who is this girl to you?\n"+name+" - Hi Pether, she is Sam.\nPether - What are you doing with her here? I know, it's one more\nof the Business of the  Carol , isn't it?\n"+name+" - Yes brother,  it's  a long history.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);

                                     buttons.buttons(null, null, "...");
                                     JOptionPane.showMessageDialog(null, "Pether - So, what do you want?\n"+name+" - We're searching to Carol, you know where is she?\nPether - Ok,Itell you sister, but   I don't want to get involved\nwith them. They're in a hospital in the south of Westfield, there\nare about 4 months\nSam - This place  isn't  far?\n"+name+" - Yes, sam.  Are you sure that they're, Pether?", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);

                                     buttons.buttons(null, null, "Ok");
                                     JOptionPane.showMessageDialog(null, "Pether - Yes, sure!\n"+name+" - Thanks for the information, bro.\nPether - Beware\nSam - Bye, Pether.\nPether - Bye Sam, be careful. "+name+", if\ndoesn't work out the business with  Carol ,\nyou can return at anytime.\n"+name+" - Ok, brother. See you...", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);

                                     JOptionPane.showMessageDialog(null, "After long seven months battling with infected, they went through\nseveral situations of danger, "+name+" and Sam finally arrived\nat the hospital. Before entering the hospital and find the flies,\n"+name+" talk briefly with sam...", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);

                                     buttons.buttons(null, null, "...");
                                     JOptionPane.showMessageDialog(null, name+" - We don't have to do this. You know that, right?\nSam - What's the other option?\n"+name+" - Go back to Pether, just...  Be done with this whole damn thing.\nSam - After all we've been through. Everything that i've done. It can't be for nothing.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);

                                     JOptionPane.showMessageDialog(null, "Both entered the hospital, but "+name+" received a blow\nto the head when she entered, but soon woke up...\n Carol  - Excuse me for the blow to the head, my men didn't\nknow who you were.\n"+name+" - Where is sam?\n Carol  - She's fine, the doctors are preparing her for the\nsurgery.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);

                                     buttons.buttons(null, null, "Ok");
                                     JOptionPane.showMessageDialog(null, name+" - Surgery?\n Carol  - The doctors told that the fungus grew on sam mutated\nand which could be taken off, so they will can do a vaccine, a vaccine!\n"+name+" - Wait... But the fungus is in the head.\n Carol  - Yes, we'll have to kill her.\n"+name+" - But can't kill her so.\n Carol  - We have no option.\n"+name+" - You know that we have.\n Carol  - it's for the good of humanity, stop being selfishit.\n"+name+" - But... Carol  - Men, take her out of here.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);

                                     buttons.buttons(null, null, "...");
                                     JOptionPane.showMessageDialog(null, "While "+name+" was being carried out of the hospital for a  Carol 's henchman,\nshe knocked out, grabbed their weapons back, and went after the surgery\nroom where Sam is.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);

                                     JOptionPane.showMessageDialog(null, name+" pick up sam before they did the surgery, but\nsam is still unconscious because of the anesthesia.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);

                                     JOptionPane.showMessageDialog(null, "In the hospital parking lot, with sam\nin her lap, "+name+" meet with  Carol ", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                     
                                     buttons.buttons("Give Sam to Carol ", "Continue the Escape", "...");
                                     choice = JOptionPane.showConfirmDialog(null, " Carol  - You can't just take it from here, even take her out of here, and then? She may\ndie attacked by an infected, that if not killed by any of these groups of cannibals.\n"+name+" - The decision isn't yours.\n Carol  - It's that she would like. And you know it. You can still do the right thing here.");
                                     cancel.cancel(choice);
                                     if(choice == JOptionPane.YES_OPTION) {   // give Sam to Carol
                                    	 buttons.buttons(null, null, "Ok");
                                    	 JOptionPane.showMessageDialog(null, " Carol  -I knew you would make the right choice.\n"+name+"- Sorry for everything.  I don't know where I was \nwith my head, me and Sam spend a lot to get here. We'll\nhave to sacrifice her, it will be for the greater good.\n Carol  - That's right, we'll take her to the operating room.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                         
                                    	 JOptionPane.showMessageDialog(null, name+" agrees to give Sam to  Carol . The doctors were able to make the vaccine,\nand some time later there was already a small town, and everything was back as\nit was before.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                         points += end.end(2);
                                         
                                     } else {  // continue the escape  -  TRUE END
                                    	 buttons.buttons(null, null, "...");
                                    	 JOptionPane.showMessageDialog(null, " Carol  - Accept it. Sam will not feel any pain\n"+name+" - No,  Carol . I can't do this.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                         
                                    	 buttons.buttons(null, null, "Ok");
                                    	 JOptionPane.showMessageDialog(null, name+"         shot her.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                    	 
                                    	 buttons.buttons(null, null, "Kill Her");
                                    	 JOptionPane.showMessageDialog(null, " Carol  - Don't kill me, let me go, you don't\nneed to do this, please.\n"+name+" - No, you would behind her", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                    	
                                    	 buttons.buttons(null, null, "...");
                                    	 JOptionPane.showMessageDialog(null, name+" put Sam in a car and they both walked away... After passing the anesthetic wears off,\nstill in the car during the trip, both talk and "+name+" just lying to Sam, saying the flies were not\nlooking for more healing and that there could be more immune people like her.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);

                                    	 JOptionPane.showMessageDialog(null, "Sam believe her and both turn to Pether's\nhouse and continue their lives normally.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                         points += end.end(1);
                                         
                                       }    
            		        	 } else {   // refuse the proposal
            		        		 buttons.buttons(null, null, "...");
            		        		 JOptionPane.showMessageDialog(null, " Carol  -  I don't accept no for an answer.\n Ryan  - Should have accepted, "+name+". This won't end well.\n"+name+" - It's nothing personal, but we can't do this, it's too\nrisky.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                     
            		        		 JOptionPane.showMessageDialog(null, " Carol  - No matter, you refused my proposal.\n Ryan  - But "+name+"...\n"+name+" - Shut up,  Ryan . We continue don't\naccepting,  Carol .", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                     
            		        		 JOptionPane.showMessageDialog(null, " Carol  - You know too much about what I will do,  I'll\nhave to kill them.\n"+name+" - Kill us? We will accept. No hard feelings.\n Carol  - Now is too late.\n Ryan  - Dammit.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);

            		        		 JOptionPane.showMessageDialog(null, " Carol  - Guys, loose the infected and let to kill them.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            		        		 
            		        		 buttons.buttons(null, null, "Ok");
            		        		 JOptionPane.showMessageDialog(null, " Ryan  - We will die.\n"+name+" - Let's fight.\n Ryan  - Be careful.\n"+name+" - They are many.,", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                     
            		        		 buttons.buttons(null, null, "...");
            		        		 JOptionPane.showMessageDialog(null, " Carol  threw a pair of pistols and\na pair of metal bars for you...\n\n Carol  - Try their luck.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);

            		        		 JOptionPane.showMessageDialog(null, " Ryan  - Take one of each,Itake the rest.\n"+name+" - Ok, let's go!", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);

            		        		 buttons.buttons(null, null, "Ok");
            		        		 JOptionPane.showMessageDialog(null, " Ryan  - Be careful, an infected \nis coming near you.\n"+name+" -Isee him.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                     points += battle.battle();
                                     
                                     buttons.buttons(null, null, "Go to  Ryan ");
                                     JOptionPane.showMessageDialog(null, " Ryan  - There is an infected attacking me.INEED HELP!", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                     
                                     buttons.buttons(null, null, "...");
                                     JOptionPane.showMessageDialog(null, name + "I kill him.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                     points += battle.battle();
                                     
                                     JOptionPane.showMessageDialog(null, " Ryan  was attacked again, but this time he died and\n Carol  are watching all...\n\n Carol  - Die bitch!\n"+name+" - NO  Ryan .  Carol , your motherfucker, bitch...\nWhy you did it?\n\n Carol  - Laughs...", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                     
                                     buttons.buttons(null, null, "Ok");
                                     JOptionPane.showMessageDialog(null, "While "+name+" offended and questioned  Carol ,\nit ended up being attacked by worms and died.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            		        		 points += end.end(2);
            		        		 
            		        	 }
            		         }
            		      }
                       }
        	        } else {   // no
        	        	choice = JOptionPane.showConfirmDialog(null, name+" - I can't leave here.\nPether - Why not?\n"+name+" - The city is a chaos!\nI can't belive you got here alive.\nPether - So you're planing\nto just stay here?");
            		    cancel.cancel(choice);
            		    if(choice == JOptionPane.YES_OPTION) {
            		    	buttons.buttons("","","Lock everything");
            		    	JOptionPane.showMessageDialog(null, name+" - Of course, It's too dangerous out there.\nPether - Fine,Istay with you, butIthink we should go.\nIf we're staying we need protection. Lock every door\nand window.\n"+name+" - Fine." ,"The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            		    	buttons.buttons("","","Ok");
            		    	
            		    	JOptionPane.showMessageDialog(null, name+" - Did you hear it?\nPether - hear what?\nIt came from outside, there is somebody out there.\nPether - I will check." ,"The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            		    	
            		    	JOptionPane.showMessageDialog(null, "A zombie atack Pether" ,"The Last Chaos",JOptionPane.PLAIN_MESSAGE);
            		    	points += tutorial.tutorial();
            		    	points += battle.battle();
            		    	
            		    	JOptionPane.showMessageDialog(null, "Pether -Igot him.\n"+name+" - Watch out Pether!!\nThere was another zombie and he got Pether. "+name+" used\nan umbrella to kill the zombie. But it was too late, He bit Pether.\n"+name+" - What doIdo Pether? What doIdo?" ,"The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            		    	
            		    	JOptionPane.showMessageDialog(null,"There was more than two. More than ten zombies came out from the woods. There was no escape to "+name+" and Amy.","The Last Chaos",JOptionPane.PLAIN_MESSAGE);
            		    	points += end.end(2);
            		    	
            		    } else {
                         	buttons.buttons("","","Ok");   // happening
                         	JOptionPane.showMessageDialog(null, name+" - Of course not. If we stay here we die.\nPether - What do we do then?\n"+name+" - We sleep here this night and tomorrow we hit the road.\nPether - Fine.\n"+name+" - We should sleep now. We leave in the morning.\nPether - Yeah,  I'm really tired.", "The Last Chaos",JOptionPane.PLAIN_MESSAGE);
                         	
                         	JOptionPane.showMessageDialog(null, "Pether - "+name+" wake up!!\n"+name+" - What is happening??\nThere were zombies everywhere.","The Last Chaos",JOptionPane.PLAIN_MESSAGE);
                         	points += tutorial.tutorial();
                         	points += battle.battle();
                         	
                         	JOptionPane.showMessageDialog(null, name+" - Behind you Pether!!","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                         	points += battle.battle();
                         	
                         	JOptionPane.showMessageDialog(null, name+", Peter and Amy died in this day trying to survive.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                         	points += end.end(2);
                         	
                         }
        	       }
        	    }
             } else {  // beginning bad side
                 JOptionPane.showMessageDialog(null, name+"'s objective is to destroy the world at any cost. \nHis plan is to get some guns from a arms dealer and\ndestroy the cure which is located in The Protectors'\nheadquarter.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                 
                 buttons.buttons("Shoot","Don't shoot","Ok");
                 choice = JOptionPane.showConfirmDialog(null, "-Please, NO! -The man says.");
                 cancel.cancel(choice);
                   
                 if(choice == JOptionPane.YES_OPTION) {  // shoot
                     buttons.buttons("pull the trigger","?","Ok");
                     choice = JOptionPane.showConfirmDialog(null, name+" -Shut up! BANG\nAndrew -What's your problem? He was our arms dealer.\n"+name+" - Now we can get the weapons for free.\nAndrew - What happens when you don't need me anymore?\n"+name+"- You die...  C'mon I was  joking. How can I kill my own brother?\nAndrew - The same way you killed our mother, you bastard.\n"+name+" - Watch what you say! ("+name+" aim to Andrew's face)\n\nINFORMATION: This character get insane sometimes and you \ndont know what are you choosing. You can play safe or see \nwhat he is going to do.");
                     cancel.cancel(choice);
                       
                     if(choice == JOptionPane.YES_OPTION) {
                         JOptionPane.showMessageDialog(null, "The gun just click, it was empty.\n\nAndrew -Oh my God, please don't do it again.\n"+name+" -How polite you are! Shut up and help me \nfind those guns. Actually you search I will take\nsome water out there.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                         
                         JOptionPane.showMessageDialog(null, "The water is in the "+name+"'s car, on the street in front of \nthe building. There is a zombie in front of the car.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                         points += tutorial.tutorial();
                         points += battle.battle();
                           
                         buttons.buttons("go to the building" , "Keep with your plan","Ok");//
                         choice = JOptionPane.showConfirmDialog(null, "After "+name+" killed the infected, He goes to the car and get a bottle of water.\nIn the same moment the building behind him explodes with his brother inside.\nIt will probably call a lot of infecteds to the area.");
                         cancel.cancel(choice);
                         if(choice == JOptionPane.YES_OPTION) {
                             buttons.buttons("try to save him","try to get out the building","Ok");
                             choice = JOptionPane.showConfirmDialog(null,name+" goes to the building to do something good and save his brother.\nBut He wasn't born to do good things. He can see that his brother still alive.");
                             cancel.cancel(choice);
                               
                             if(choice == JOptionPane.YES_OPTION) {  // save
                                 JOptionPane.showMessageDialog(null, name+" goes faster he can to get his brother out of\nthe building but the flames are everywhere and \nonce he realizes, his brother  isn't  there anymore \nand he is traped.\n\n"+name+" burn in flames trying to do a good thing.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                 points += end.end(2);
                                 
                             } else{
                                 JOptionPane.showMessageDialog(null, name+" try to get out the building but the whole \nplace is already on flames.\n\nHis mistake was try to do a good thing.","The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                 points += end.end(2);
                                 
                             }
                         } else {   // keep plan
                             buttons.buttons(null , null ,"Go to The Protectors' headquarter");
                             JOptionPane.showMessageDialog(null, "The weapons are not an option anymore. Now\n"+name+" needs to find a way to get inside The \nProtectors' headquarter.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                             
                             buttons.buttons(null , null ,"Ok");
                             JOptionPane.showMessageDialog(null, "On the way to The Protectors' headquarter "+name+" got atacked by an infected!", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                             points += battle.battle();
                             
                             buttons.buttons("takedown the guard" , "go through the window" ,"Ok");
                             choice = JOptionPane.showConfirmDialog(null, name+" -Finally, nowImust find the cure, unfortunately I have no idea\nwhere  it's .\n\nOnce "+name+" gets there he stays for one hour watching their movements\nand find a way to get in.\n->He saw a guard vulnerable. He could takedown him.\n->He also saw an open window.");
                             cancel.cancel(choice);
                             if(choice == JOptionPane.YES_OPTION) {  // true end
                                 JOptionPane.showMessageDialog(null, name+" sneaks until he gets to the guard.\nHe knocked down the guard and dragged\nhim to a room behind him.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                 
                                 JOptionPane.showMessageDialog(null, "guard - oh my head!\n"+name+" - Finaly awoken.\nguard - Where am I? "+name+" is that you?\n"+name+" - I toLD YOU TO SPEAK?\n"+name+" stabs his leg with a knife.\nguard - ahhhhh.\n"+name+" - now let's have a chat...", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                 
                                 buttons.buttons(null, null,"get the TNTs");
                                 JOptionPane.showMessageDialog(null,"The guard gently told "+name+" everything.\nLooks like the cure is located on the top\nof the building A.\nThe Protectors have some TNTs that\nwould be useful.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                 
                                 buttons.buttons(null, null,"explode it");
                                 JOptionPane.showMessageDialog(null, name+" took the TNTs from his own enemy and now he will finally destroy the world.\n"+name+" runs through the hallways that someday he called HOME.\n\n"+name+" puts every single TNT he found in the ground flood of the building A.\n" ,"The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                 points += end.end(1);
                                 
                             } else {
                                 buttons.buttons(null,null,"Shoot your dad");
                                 JOptionPane.showMessageDialog(null, name+" jumps over the window.\n?? - Stop right there.\n"+name+" - hey dad.\nJesse - I told you to go and never come back, son.\n"+name+" - That was a lovely day.\nJesse - The day you killed your mother and sister.\n"+name+" - And today is the day  I'll kill you." , "The Last Chaos" , JOptionPane.PLAIN_MESSAGE);
                                 
                                 buttons.buttons(null, null, "ok");
                                 JOptionPane.showMessageDialog(null, "?? - No, today is the day you die. BANG\n"+name+" - Andrew, you betrayed me.\nAndrew - You left me to die.\nAndrew - Sorry dad for everythingIdid.\n (they hug)\n\n             "+name+" bleed to death..." , "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                                 points += end.end(2);
                                 
                             }
                         }
                     } else {  // dream
                         JOptionPane.showMessageDialog(null, "For a moment "+name+" loses his mind (thats new) and he feels like in a dream.\nHe fells fire on his foots but it does not hurt. He walks forward and "+name+"\ncan hear a person asking for help.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                         
                         JOptionPane.showMessageDialog(null, name+" can see a person really similar to his brother.\nIt's actualy an infected and he will atack you!", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                         points += tutorial.tutorial();
                         points += battle.battle();
                         
                         buttons.buttons(null,null,"??");
                         JOptionPane.showMessageDialog(null, "Once "+name+" wakes up, he is inside his car. He looks through the window\nand see the building on fire. There are lots of zombies out there.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                         
                         buttons.buttons(null,null,"light the candle of the cake");
                         JOptionPane.showMessageDialog(null, name+" sees himself driving a sport car. He goes faster than ligth.\nThen he sees himself with a cake in the hand. It looks very good.\nHe hear voices from far away, They say - drop the cake!\n"+name+" - this cake is mine!!\nIn the middle of them you can see your father.\n\n"+name+" - Is your birthday dad??" , "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                         points += end.end(2);
                         
                       }
                 } else {   // don't shoot
                     buttons.buttons("go check yourself ","send the man to check","Ok");
                     choice = JOptionPane.showConfirmDialog(null, "Andrew -Hold on, we don't know where the weapons are. \n"+name+" -Thas true my brother, where is it?\nThe man -It's behind that closet,Itell you anything \nplease don't hurt me anymore.\nThe man says without one of his fingers.");
                     cancel.cancel(choice);
                     if(choice == JOptionPane.YES_OPTION) {   // lose your leg
                         buttons.buttons("Go by car" ,"Go by boat","Ok"); 
                         JOptionPane.showMessageDialog(null, name+" -Keep your eyes on him Andrew, and you -("+name+"\nkicked the man in the face with his right leg) - stay down.\n"+name+" pushes the closet out the way when a CLICK stops him.\nAndrew - It's a trap, get ou- BOOOOOOOOM", "", JOptionPane.PLAIN_MESSAGE);
                         
                         JOptionPane.showMessageDialog(null, name+" wakes up and try to realize where he is. But he can't.\nAfter some seconds he remember the explosion and have a cackle.\nAndrew - "+name+", are you okay?\n"+name+" -  I'm fine, let's just keep with the plan. Where are we?\nAndrew - Sorry about your leg.Ihad to do this.\n"+name+" - What do you mean? My leg is fin--\n[...]\n"+name+" removed the blanket and his leg wasn't there.\n"+name+" - It's fine... Where are we anyway?\nAndrew - We are in a military airport near from The Protectors' headquarter.\n"+name+" - Ok.");
                         
                         choice = JOptionPane.showConfirmDialog(null, "The portectors' headquarter is in a high building beside a river.\nThey can go by car or boat (found in the military airport).\n=>If you go by car you must escape through the building.\n=>If you go by boat you will need to use a parachute but there is\nonly one.");
                         cancel.cancel(choice);

                         if(choice == JOptionPane.YES_OPTION) {      // car                                                                                                                                                                   //about twenty caught
                            JOptionPane.showMessageDialog(null, name+" - Fine, let's get it done.\nAndrew - How are we going to do this?\n"+name+" - We take a car and shoot them all.\nAndrew - Ok, but you know my reasons to do this right?\n"+name+" - Yeah because dad killed your infected \ngirlfriend.Iknow that better than anyone.\nAndrew - She wasn't infected!!\n"+name+" -Iknow, calm down.", "The Last Chaos",JOptionPane.PLAIN_MESSAGE);
                            
                            JOptionPane.showMessageDialog(null, "They go to The Protectors' headquarter with the military car.\nThey run over two guards and then they get cover behind the car.\n"+name+" - Shoot them Andrew!\nAbout twenty guards showed up.\nAndrew - They are too many!\n\nAndrew got shot in the head and they took "+name+" to prision for the\nrest of his days.\n\n???? - I told you to go and don't comeback son." ,"The Last Chaos",JOptionPane.PLAIN_MESSAGE);
                            points += end.end(2);
                            
                         } else { // boat
                            JOptionPane.showMessageDialog(null, name+" - Fine, let's get it done.\nAndrew - How are we going to do this?\n"+name+" - We take a boat, we get the cure,\nwe jump from the top of the building\nwith those parachutes and escape\nwith the boat. Easy right?" , "The Last Chaos" , JOptionPane.PLAIN_MESSAGE);
                            
                            JOptionPane.showMessageDialog(null, "They got there stealthily with the boat allowing them a easy way in.\nAndrew helped "+name+" to walk. It wasn't hard to get in the top of\nthe building since all the guards were in the main gate. They got \nto the top.\nAndrew - We couldn't find the cure. What do we do?\n"+name+" - The cure is inside here, so, if we destroy this building\nwe destroy the cure.\nAndrew - How are we going to destroy it?\n"+name+" - Like that.\n   "+name+" stabs Andrew. Then he jumps off the building and\n   activate the parchute and the bombs which were in Andrew's\n   backpack." , "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                            points += end.end(2);
                            
                           }
                     } else {  // die
                         buttons.buttons(null, null,"Help the man");
                         JOptionPane.showMessageDialog(null, name+" - You check.\nThe man - Why me? I can barely walk!\n"+name+" grab the man and throw him on the closet direction.\nThe man tries to push the closet but it's too heavy.\nThe man -Ineed some help.");
                         
                         buttons.buttons(null, null,"Ok");
                         JOptionPane.showMessageDialog(null, name+" helps the man to push it.\nThe man - At least you will die asshole.\nEveryone hear a CLICK, after that the whole place explodes.\n\n                 Tip of the day: help no one.");
                         points += end.end(2);
                         
                     }
                 }
             }
		     
		     loop = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
			 cancel.cancel(loop);
		     
		     int i = 0;
		     while(points < score[i]) {
		    	 i++;
		     }
		     
		     for(int h = 4; h >= 0; h--) {
		    	 if(i == h) {
		    		 score[h] = points;
		    		 scoreName[h] = name;
		    	 } else if (h > 0) {
		    		 score[h] = score[h-1];
		    		 scoreName[h] = scoreName[h-1];
		    	   }  
		     }
		     JOptionPane.showMessageDialog(null, "RANKING\n\n1- "+scoreName[0]+" "+score[0]+"\n2- "+scoreName[1]+" "+score[1]+"\n3- "+scoreName[2]+" "+score[2]+"\n4- "+scoreName[3]+" "+score[3]+"\n5- "+scoreName[4]+" "+score[4]);
		 }
	  } 
}