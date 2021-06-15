// QUEUES AND STACKS
class SLNode {
    constructor(value) {
        this.value = value
        this.next = null
    }
}

// ___ _  _ ____ ____ ___  ____ _   _ 
//  |  |  | |___ [__  |  \ |__|  \_/  
//  |  |__| |___ ___] |__/ |  |   |     

// LAST IN FIRST OUT
// LIFO - STACKS
class ArrayStack {
    constructor(items = []) {
        this.items = items;
    }

    isEmpty() {
        if (items == null) {
            console.log("This is this is Empty.")
            return true;
        }
    }
    push(value) {
        this.items.push(value)
    }
    pop() {
    }
    size() {
    }
    peek() {
        // return top item without removing
    }

}

class SLStack {
    constructor() {
        this.head = null;
        this.length = 0;
    }

    isEmpty() {
    }

    // Adds a new node with the given value in front of the head node.
    push(value) {
    }

    // Removes the head node
    // return the popped value -- important!
    pop() {
    }

    peek() {

    }

    printPretty() {
        let runner = this.head;
        let printString = "~ SLStack ~ HEAD--(";
        while (runner && runner.next) {
            printString += `${runner.value})->(`;
            runner = runner.next;
        }
        printString += `${runner.value})->null\n`;
        console.log(printString);
    }

    ////  EXTRA  /////
    // Reverses stack with the order of the nodes reversed
    // For this exercise, do NOT try to re-point all the pointers
    // use an extra stack as storage and utilize the pop and push 
    // methods. Hint: you can re-point the head.
    reverse() {
    }
}
    stack = [];
    list = ArrayStack(stack);