const nums1 = [5, 3, 4, 2, 1];
const nums2 = [9, 2, 5, 6, 4, 3, 7, 10, 1, 8];
const nums3 = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1];

function bubbleSort(nums) {
    var sorted = false;

    for (var i = 0; i < nums.length; i++) {
        sorted = false;

        for (var j = 0; j < nums.length; j++) {
            if (nums[j] > nums[j + 1]) {
                var temp = nums[j]
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
                sorted = true;
            }
        }
        if (!sorted) {
            break;
        }
    }
    console.log(nums)
}


bubbleSort(nums1);
bubbleSort(nums2);
bubbleSort(nums3);