class Card {
    constructor(name, cost){
        this.name = name;
        this.cost = cost;
        
    }
}

class Unit extends Card {
    constructor(name, cost, power, res){
    super(name, cost)
    this.power = power;
    this.res = res;
    }
    attack(target){
        this.target=target;
        target.health -= this.power;
    }

}

class Effect extends Card {
    constructor(name, cost, text, stat, mag){
        super(name, cost);
        this.text = text;
        this.stat = stat;
        this.mag = mag;
    }
    attack(target){
        this.target = target;
        if(this.stat=="resilience"){
            target.resilience+=this.mag;
        }
        if(this.stat=="power"){
            target.power+=this.mag;
        }
    }

}

const redNinja = new Unit("Red Belt Ninja", 3, 3, 4);
const blackNinja = new Unit("Black Belt Ninja", 4, 5, 4);

const effCard1 = new Effect("Hard Algorithm", 2, "increase target's resilience by 3", "resilience", 3);
const effCard2 = new Effect("Unhandled Promise Rejection", 1, "reduce target's resilience by 2", "resilience", -2);
const effCard3 = new Effect("Pair Programming", 3, "increase target's power by 2", "power", 2);

effCard1.attack(redNinja);
effCard2.attack(redNinja);
effCard3.attack(redNinja);
redNinja.attack(blackNinja);
