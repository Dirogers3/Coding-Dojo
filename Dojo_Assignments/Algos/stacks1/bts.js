///----------MONDAY-----------///


class BSTNode {
    constructor(value) {
        this.value = value
        this.left = null
        this.right = null
    }
}
class BST {
    constructor() {
        this.root = null
    }


    insert(val) {
        let newNode = new BSTNode(val);
        let runner = this.root;
        if (this.root == null) {
            this.root = newNode;
        }
        else {
            if (val < runner.value && runner.left != null) {
                runner = runner.left;
            }
            if (val < runner.value && runner.left == null) {
                runner.left = newNode;
            }
            if (val > runner.value && runner.right != null) {
                runner = runner.right;
            }
            if (val > runner.value && runner.right == null) {
                runner.right = newNode;
            }
            else {
                console.log("Something went wrong");
            }
        }
    }
}

let testTree = new BST();
testTree.insert(10);
testTree.insert(20);
testTree.insert(15);
// testTree.insert(2);
// testTree.insert(7);