// QUEUES AND STACKS
class SLNode {
    constructor(value) {
        this.value = value
        this.next = null
    }
}


// FIFO - QUEUES
class SLQueue {
    constructor() {
        this.head = null;
        this.tail = null;
    }

    enqueue(value) {
        var newNode = new SLNode(value);
        if(this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                this.tail.next = newNode;
                this.tail = newNode;
            }

    }

    // THURS &/or WED EXTRA
    dequeue() {
        this.head = this.head.next;
    }
    printPretty() {
        let runner = this.head;
        let printString = "~ SLQueue ~ --(HEAD ";
        while (runner && runner.next) {
            printString += runner === this.tail ? "TAIL " : "";
            printString += `${runner.value})->(`;
            runner = runner.next;
        }
        printString += runner === this.tail ? "TAIL " : "";
        printString += `${runner.value})->null\n`;
        console.log(printString);
    }

}

var myQueue = new SLQueue();
myQueue.enqueue(4);
myQueue.enqueue(5);
myQueue.enqueue(6);
myQueue.enqueue(7);
myQueue.printPretty();
myQueue.dequeue();
myQueue.printPretty();