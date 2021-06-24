package com.ianrogers.dojogold.controllers;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private boolean activeSession  =false;
	private Integer gold = 0;
	private ArrayList<String> ledger = new ArrayList<String>();
	
	@RequestMapping("/")
	public String home(HttpSession s) {
		if (activeSession == false) {
			s.setAttribute("gold", 0);
			s.setAttribute("ledger", ledger);
			activeSession = true;
		}
		return"index.jsp";
	}
	
	@RequestMapping(value="/clickfarm", method=RequestMethod.POST)
	public String farm(HttpSession s) {
		Integer recievedGold = new Random().nextInt(10)+10;
		gold += recievedGold;
		s.setAttribute("gold", gold);
		ledger.add("You've earned " + recievedGold + " gold." );
		s.setAttribute("recievedGold", recievedGold);
		return "redirect:/";
	}
	@RequestMapping(value="/clickcave", method=RequestMethod.POST)
	public String cave(HttpSession s) {
		Integer recievedGold = new Random().nextInt(5+1)+4;
		gold += recievedGold;
		s.setAttribute("gold", gold);
		ledger.add("You've earned " + recievedGold + " gold." );
		s.setAttribute("recievedGold", recievedGold);
		return "redirect:/";
	}
	@RequestMapping(value="/clickhouse", method=RequestMethod.POST)
	public String house(HttpSession s) {
		Integer recievedGold = new Random().nextInt(2+1)+2;
		gold += recievedGold;
		s.setAttribute("gold", gold);
		ledger.add("You've earned " + recievedGold + " gold." );
		s.setAttribute("recievedGold", recievedGold);
		return "redirect:/";
	}
	@RequestMapping(value="/clickcasino", method=RequestMethod.POST)
	public String casino(HttpSession s) {
		Integer recievedGold = new Random().nextInt(50+10)-50;
		gold += recievedGold;
		s.setAttribute("gold", gold);
		if (recievedGold > 0) {
			ledger.add("You earned " + recievedGold + " gold at the casino.");			
		} else {
			ledger.add("You lost  " + recievedGold + " gold at the casino.");
		}
		ledger.add("You've earned" + recievedGold + "gold." );
		s.setAttribute("recievedGold", recievedGold);
		return "redirect:/";
	}
	
}
