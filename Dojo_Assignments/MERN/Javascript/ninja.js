class Ninja {
    constructor(name, health, speed = 3, strength = 3) {
    this.name = name;
    this.health = health;
    this.speed = speed;
    this.strength = strength;
    }

    sayName(){
        console.log(this.name);
    }

    showStats() {
        console.log("Name: "+ this.name);
        console.log("Health: " + this.health);
        console.log("Speed: " + this.speed);
        console.log("Strength: " + this.strength);
    }

    drinkSake() {
        this.health += 10;
    }
}

const ninja = new Ninja("Bob", 3);
ninja.sayName();
ninja.showStats();
ninja.drinkSake();
ninja.showStats();
